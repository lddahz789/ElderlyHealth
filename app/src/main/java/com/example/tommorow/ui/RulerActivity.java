package com.example.tommorow.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.R;
import com.example.tommorow.entity.FoodModel;
import com.example.tommorow.utils.SharedPreferencesUtil;
import com.example.tommorow.utils.TagUtils;
import com.example.tommorow.view.PieChartView;
import com.example.tommorow.view.RulerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 添加食物的最后一个页面的Activity
 */

public class RulerActivity extends BaseActivity {
    @BindView(R.id.rulerView)
    RulerView rulerView;
    @BindView(R.id.choose_Data)
    TextView chooseData;
    @BindView(R.id.addBtn)
    Button addBtn;
    @BindView(R.id.eat_pie_chart)
    PieChartView eatPieChart;
    private int data;
    private FoodModel foodModel;
    private int type;
    List<PieChartView.PieceDataHolder> nutritionDataHolders = new ArrayList<>();
    private int proteinColor = 0xFF77CCAA;
    private int fatColor = 0xFF7700AA;
    private int carbohydratesColor = 0xFF77CCFF;

    @Override
    public int getContnetView() {
        return R.layout.activity_ruler;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        foodModel = (FoodModel) getIntent().getSerializableExtra(Const.ITEM_DATA);
        type = getIntent().getIntExtra(Const.TYPE, 0);
        setListener();
        title.setText(getResources().getString(R.string.add_food));
    }
    //初始化尺子的页面
    private void setListener() {
        rulerView.setStartValue(20);
        rulerView.setEndValue(1000);
        rulerView.setPartitionWidthInDP(40);
        rulerView.setPartitionValue(10);
        rulerView.setSmallPartitionCount(1);
        rulerView.setmValue(170);
        rulerView.setValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(int intVal, int fltval) {
                data = intVal;
                chooseData.setText(intVal + " " + "g");
            }
        });
        double total = foodModel.getFat() + foodModel.getCarbohydrates() + foodModel.getProtein();
        DecimalFormat df=new DecimalFormat(".##");
        double d=1252.2563;
        String st=df.format(d);
        double fatPercent = changeDouble((foodModel.getFat()*100)/total);
        double proteinPercent =  changeDouble((foodModel.getProtein()*100)/total);
        double CarbohydratesPercent = changeDouble((100 - fatPercent - proteinPercent));

        nutritionDataHolders.add(new PieChartView.PieceDataHolder((float) foodModel.getFat(), fatColor, fatPercent + "%" + getResources().getString(R.string.fat)));
        nutritionDataHolders.add(new PieChartView.PieceDataHolder((float) foodModel.getProtein(), proteinColor, proteinPercent + "%" + getResources().getString(R.string.protein)));
        nutritionDataHolders.add(new PieChartView.PieceDataHolder((float) foodModel.getCarbohydrates(), carbohydratesColor, CarbohydratesPercent + "%" + getResources().getString(R.string.carbohydrates)));
        eatPieChart.setData(nutritionDataHolders);

    }
    public double changeDouble(Double dou) {
        NumberFormat nf = new DecimalFormat("0.0 ");
        dou = Double.parseDouble(nf.format(dou));
        return dou;
    }
    @OnClick(R.id.addBtn)
    public void onViewClicked() {
        foodModel.setAmount(data);
        List<FoodModel> oldFoodList = SharedPreferencesUtil.getInstance(this).getList(TagUtils.getTag(type, this));
        oldFoodList.add(foodModel);
        SharedPreferencesUtil.getInstance(this).putList(TagUtils.getTag(type, this), oldFoodList);
        Toast.makeText(RulerActivity.this, R.string.add_success, Toast.LENGTH_LONG).show();
        finish();
    }
}
