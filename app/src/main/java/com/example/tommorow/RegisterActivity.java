package com.example.tommorow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tommorow.db.UserDBUtils;
import com.example.tommorow.entity.User;
import com.example.tommorow.utils.StringUtils;
import com.example.tommorow.wheelview.NumericWheelAdapter;
import com.example.tommorow.wheelview.OnWheelScrollListener;
import com.example.tommorow.wheelview.WheelView;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/22.
 * Controller class, corresponding to layout file
 * This class will handle the registration logic
 * Layout file name: activity_register.xml
 */
public class RegisterActivity extends BaseActivity {
    @BindView(R.id.fullName)
    EditText fullName;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.childName)
    EditText childName;
    @BindView(R.id.passWord)
    EditText passWord;
    @BindView(R.id.weight)
    EditText weight;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.year)
    WheelView year;
    @BindView(R.id.month)
    WheelView month;
    @BindView(R.id.day)
    WheelView day;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.register)
    Button register;
    private String mName, mChildName, mPassWord, mBirthday, mGender, mWeight, mFullName;
    private List<User> userList;
    private int mYear = 1996;
    private int mMonth = 0;
    private int mDay = 1;
    private OnWheelScrollListener scrollListener = new OnWheelScrollListener() {
        @Override
        public void onScrollingStarted(WheelView wheel) {

        }

        @Override
        public void onScrollingFinished(WheelView wheel) {
            int n_year = year.getCurrentItem() + 1910;//
            int n_month = month.getCurrentItem() + 1;//
            initDay(n_year, n_month);

        }
    };

    @Override
    public int getContnetView() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(R.string.register);
        setEditTextInhibitInputSpace(name);
        setEditTextInhibitInputSpace(childName);
        setEditTextInhibitInputSpace(passWord);
        getDataPick();
// get the gender information
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)RegisterActivity.this.findViewById(radioButtonId);
        mGender = "male";

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                int radioButtonId = arg0.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)RegisterActivity.this.findViewById(radioButtonId);
                mGender = rb.getText().toString().toLowerCase();
            }
        });

}

    private void getDataPick() {
        Calendar c = Calendar.getInstance();
        int norYear = c.get(Calendar.YEAR);
        int curYear = mYear;
        int curMonth = mMonth + 1;
        int curDate = mDay;
        year.setAdapter(new NumericWheelAdapter(1910, norYear));
        year.setLabel(getString(R.string.year));
        year.setCyclic(true);
        year.setCurrentItem(norYear - 1909);
        year.addScrollingListener(scrollListener);
        month.setAdapter(new NumericWheelAdapter(1, 12, "%02d"));
        month.setLabel(getString(R.string.month));
        month.setCyclic(true);
        month.setCurrentItem(curMonth);
        month.addScrollingListener(scrollListener);
        initDay(curYear, curMonth);
        day.setCurrentItem(curDate);
        day.setLabel(getString(R.string.day));
        day.setCyclic(true);
        year.setCurrentItem(curYear - 1910);
        month.setCurrentItem(curMonth - 1);
        day.setCurrentItem(curDate - 1);
    }

    public boolean isValidPhone(String phone){
        String regex = "^[0][0-9]{9}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public void alertWindow(String str){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(RegisterActivity.this);
        builder1.setTitle("Warning");
        builder1.setMessage(str);
        builder1 .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    @OnClick(R.id.register)
    public void onViewClicked() {
        mName = name.getText().toString().trim();
        mChildName = childName.getText().toString().trim();
        mPassWord = passWord.getText().toString().trim();
        mFullName = fullName.getText().toString().trim();
        mWeight = weight.getText().toString().trim();


        mBirthday = year.getTextItem(year.getCurrentItem()) + "-" + String.valueOf(month.getCurrentItem() + 1) + "-" + String.valueOf(day.getCurrentItem() + 1);
        if (TextUtils.isEmpty(StringUtils.c(mName)) || TextUtils.isEmpty(StringUtils.c(mChildName)) || TextUtils.isEmpty(StringUtils.c(mPassWord)) || TextUtils.isEmpty(StringUtils.c(mFullName)) ||TextUtils.isEmpty(StringUtils.c(mWeight))) {
            Toast.makeText(RegisterActivity.this, "Please complete your information", Toast.LENGTH_LONG).show();
            return;
        } else if(!isValidPhone(mName) && !isValidPhone(mChildName)){
            alertWindow("Please use validate phone number in Austalia! \n E.g. 0432068888");
        } else {
            boolean isNewUser = true;
            UserDBUtils userDBUtils = new UserDBUtils(this);
            userList = userDBUtils.queryAllUser();
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getChildName().equals(mChildName)) {
                    Toast.makeText(RegisterActivity.this, "Account already exists，Please try again", Toast.LENGTH_LONG).show();
                    isNewUser = false;
                    return;
                }

            }
            if (isNewUser) {
                User newUser = new User(mName, mChildName, mPassWord, mBirthday, mWeight, mGender,mFullName);
                userDBUtils.regist(newUser);
                Toast.makeText(RegisterActivity.this, "Account Created!", Toast.LENGTH_LONG).show();
                finish();
            }

        }
    }

    /**
     * 禁止EditText输入空格
     *
     * @param editText
     */
    public void setEditTextInhibitInputSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ")) {
                    return "";
                } else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    /**
     * @param year
     * @param month
     * @return
     */
    private int getDay(int year, int month) {
        int day = 30;
        boolean flag = false;
        switch (year % 4) {
            case 0:
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 2:
                day = flag ? 29 : 28;
                break;
            default:
                day = 30;
                break;
        }
        return day;
    }

    /**
     */
    private void initDay(int arg1, int arg2) {
        day.setAdapter(new NumericWheelAdapter(1, getDay(arg1, arg2), "%02d"));
    }
}
