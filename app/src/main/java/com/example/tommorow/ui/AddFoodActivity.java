package com.example.tommorow.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.R;
import com.example.tommorow.adapter.HistoryAdapter;
import com.example.tommorow.entity.FoodModel;

import org.apache.commons.lang3.text.WordUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jxl.Sheet;
import jxl.Workbook;

/**
 * 添加食物的Activity
 */

public class AddFoodActivity extends BaseActivity {

    @BindView(R.id.key)
    EditText key;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.empty)
    TextView empty;
    private List<FoodModel> allFood = new ArrayList<>();
    private HistoryAdapter searchAdapter;
    List<FoodModel> searchModle = new ArrayList<>();
    private ProgressDialog progressDialog;
    private int type;

    @Override
    public int getContnetView() {
        return R.layout.activity_add;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type=getIntent().getIntExtra(Const.TYPE,0);
        ButterKnife.bind(this);
        title.setText("Add Food");
        progressDialog = new ProgressDialog(this);
        searchAdapter = new HistoryAdapter(searchModle, this, 2);
        listView.setAdapter(searchAdapter);
        new ExcelDataLoader().execute("food.xls");
        setEvent();
    }

    private void setEvent() {
        //监听输入框的文字信息变化
        key.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputStr = s.toString();
                //Convert first letter to Capital
                String cap = WordUtils.capitalize(inputStr);
                search(cap);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //listView的item点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AddFoodActivity.this, RulerActivity.class);
                intent.putExtra(Const.ITEM_DATA, searchModle.get(position));
                intent.putExtra(Const.TYPE,type);
                startActivity(intent);
            }
        });
    }
        //通过关键字来搜索食物
    public void search(String key) {
        searchModle.clear();
        for (FoodModel foodModel : allFood) {
            if (foodModel.getFoodName().contains(key)) {
                searchModle.add(foodModel);
            }
        }

        empty.setVisibility(searchModle.size()==0?View.VISIBLE:View.GONE);
        searchAdapter.notifyDataSetChanged();
    }

    /**
     * 获取 excel 表格中的数据,不能在主线程中调用
     *
     * @param xlsName excel 表格的名称
     * @param index   第几张表格中的数据
     */

    private ArrayList<FoodModel> getXlsData(String xlsName, int index) {
        ArrayList<FoodModel> foodModelArrayList = new ArrayList<FoodModel>();
        AssetManager assetManager = getAssets();

        try {
            Workbook workbook = Workbook.getWorkbook(assetManager.open(xlsName));
            Sheet sheet = workbook.getSheet(index);

            int sheetNum = workbook.getNumberOfSheets();
            int sheetRows = sheet.getRows();
            int sheetColumns = sheet.getColumns();

            Log.d("TAG", "the num of sheets is " + sheetNum);
            Log.d("TAG", "the name of sheet is  " + sheet.getName());
            Log.d("TAG", "total rows is 行=" + sheetRows);
            Log.d("TAG", "total cols is 列=" + sheetColumns);

            for (int i = 1; i < sheetRows; i++) {
                FoodModel foodModel = new FoodModel();
                //前面是列 后面是行
                foodModel.setFoodName(sheet.getCell(2, i).getContents());
                foodModel.setEnergy(sheet.getCell(4, i).getContents());
                foodModel.setProtein(Double.parseDouble(sheet.getCell(7, i).getContents()));
                foodModel.setFat(Double.parseDouble(sheet.getCell(8, i).getContents()));
                foodModel.setCarbohydrates(Double.parseDouble(sheet.getCell(9, i).getContents()));
                foodModelArrayList.add(foodModel);
            }

            workbook.close();

        } catch (Exception e) {
            Log.e("TAG", "read error=" + e, e);
        }

        return foodModelArrayList;
    }

    //在异步方法中 调用
    private class ExcelDataLoader extends AsyncTask<String, Void, ArrayList<FoodModel>> {

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading,Please Wait......");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }

        @Override
        protected ArrayList<FoodModel> doInBackground(String... params) {
            return getXlsData(params[0], 0);
        }

        @Override
        protected void onPostExecute(ArrayList<FoodModel> foodModels) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            allFood.clear();
            allFood.addAll(foodModels);
        }
    }
}
