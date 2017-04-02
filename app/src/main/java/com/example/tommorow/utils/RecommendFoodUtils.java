package com.example.tommorow.utils;

import com.example.tommorow.entity.RecommendFood;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐食物的工具类  数据是你给的excel数据
 */

public class RecommendFoodUtils {
    private static RecommendFoodUtils instance;
    private List<List<RecommendFood>> proteinData = new ArrayList<>();
    private List<List<RecommendFood>> fatData = new ArrayList<>();
    private List<List<RecommendFood>> carbohydateData = new ArrayList<>();

    public static RecommendFoodUtils getInstance() {
        if (instance == null) {
            synchronized (RecommendFoodUtils.class) {
                if (instance == null) {
                    instance = new RecommendFoodUtils();
                }
            }
        }
        return instance;
    }

    public RecommendFoodUtils() {
        initCarbohydate();
        initFat();
        initProtein();
    }

    public List<List<RecommendFood>> getRecommendFat() {
        return fatData;
    }

    public List<List<RecommendFood>> getRecommendProtein() {
        return proteinData;
    }

    public List<List<RecommendFood>> getRecommendCarbohydate() {
        return carbohydateData;
    }

    private void initCarbohydate() {
        List<RecommendFood> firstList = new ArrayList<>();
        List<RecommendFood> secondList = new ArrayList<>();
        List<RecommendFood> thirdList = new ArrayList<>();
        List<RecommendFood> fourthList = new ArrayList<>();
        List<RecommendFood> fifthList = new ArrayList<>();
        List<RecommendFood> sixthList = new ArrayList<>();
        List<RecommendFood> seventhList = new ArrayList<>();
        List<RecommendFood> eighthList = new ArrayList<>();
        List<RecommendFood> ninethList = new ArrayList<>();
        List<RecommendFood> tenthList = new ArrayList<>();
        List<RecommendFood> eleventhList = new ArrayList<>();
        List<RecommendFood> twelfthList = new ArrayList<>();
        firstList.add(new RecommendFood(20, "Biscuit, sweet, oatmeal, commercial"));
        firstList.add(new RecommendFood(20, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        firstList.add(new RecommendFood(20, "Potato, mashed, dried powder"));
        firstList.add(new RecommendFood(58, "French toast, white bread, plain"));
        firstList.add(new RecommendFood(84, "Dip, pumpkin or sweet potato, commercial"));

        secondList.add(new RecommendFood(60, "Biscuit, sweet, oatmeal, commercial"));
        secondList.add(new RecommendFood(60, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        secondList.add(new RecommendFood(60, "Potato, mashed, dried powder"));
        secondList.add(new RecommendFood(176, "French toast, white bread, plain"));
        secondList.add(new RecommendFood(257, "Dip, pumpkin or sweet potato, commercial"));

        thirdList.add(new RecommendFood(100, "Biscuit, sweet, oatmeal, commercial"));
        thirdList.add(new RecommendFood(100, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        thirdList.add(new RecommendFood(98, "Potato, mashed, dried powder"));
        thirdList.add(new RecommendFood(292, "French toast, white bread, plain"));
        thirdList.add(new RecommendFood(426, "Dip, pumpkin or sweet potato, commercial"));

        fourthList.add(new RecommendFood(139, "Biscuit, sweet, oatmeal, commercial"));
        fourthList.add(new RecommendFood(140, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        fourthList.add(new RecommendFood(138, "Potato, mashed, dried powder"));
        fourthList.add(new RecommendFood(407, "French toast, white bread, plain"));
        fourthList.add(new RecommendFood(595, "Dip, pumpkin or sweet potato, commercial"));

        fifthList.add(new RecommendFood(179, "Biscuit, sweet, oatmeal, commercial"));
        fifthList.add(new RecommendFood(180, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        fifthList.add(new RecommendFood(177, "Potato, mashed, dried powder"));
        fifthList.add(new RecommendFood(523, "French toast, white bread, plain"));
        fifthList.add(new RecommendFood(764, "Dip, pumpkin or sweet potato, commercial"));

        sixthList.add(new RecommendFood(218, "Biscuit, sweet, oatmeal, commercial"));
        sixthList.add(new RecommendFood(220, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        sixthList.add(new RecommendFood(216, "Potato, mashed, dried powder"));
        sixthList.add(new RecommendFood(639, "French toast, white bread, plain"));
        sixthList.add(new RecommendFood(932, "Dip, pumpkin or sweet potato, commercial"));

        seventhList.add(new RecommendFood(258, "Biscuit, sweet, oatmeal, commercial"));
        seventhList.add(new RecommendFood(260, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        seventhList.add(new RecommendFood(255, "Potato, mashed, dried powder"));
        seventhList.add(new RecommendFood(755, "French toast, white bread, plain"));
        seventhList.add(new RecommendFood(1101, "Dip, pumpkin or sweet potato, commercial"));

        eighthList.add(new RecommendFood(297, "Biscuit, sweet, oatmeal, commercial"));
        eighthList.add(new RecommendFood(300, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        eighthList.add(new RecommendFood(294, "Potato, mashed, dried powder"));
        eighthList.add(new RecommendFood(870, "French toast, white bread, plain"));
        eighthList.add(new RecommendFood(1270, "Dip, pumpkin or sweet potato, commercial"));

        ninethList.add(new RecommendFood(337, "Biscuit, sweet, oatmeal, commercial"));
        ninethList.add(new RecommendFood(340, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        ninethList.add(new RecommendFood(333, "Potato, mashed, dried powder"));
        ninethList.add(new RecommendFood(986, "French toast, white bread, plain"));
        ninethList.add(new RecommendFood(1439, "Dip, pumpkin or sweet potato, commercial"));

        tenthList.add(new RecommendFood(377, "Biscuit, sweet, oatmeal, commercial"));
        tenthList.add(new RecommendFood(380, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        tenthList.add(new RecommendFood(372, "Potato, mashed, dried powder"));
        tenthList.add(new RecommendFood(1102, "French toast, white bread, plain"));
        tenthList.add(new RecommendFood(1608, "Dip, pumpkin or sweet potato, commercial"));

        eleventhList.add(new RecommendFood(416, "Biscuit, sweet, oatmeal, commercial"));
        eleventhList.add(new RecommendFood(419, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        eleventhList.add(new RecommendFood(411, "Potato, mashed, dried powder"));
        eleventhList.add(new RecommendFood(1218, "French toast, white bread, plain"));
        eleventhList.add(new RecommendFood(1777, "Dip, pumpkin or sweet potato, commercial"));


        twelfthList.add(new RecommendFood(456, "Biscuit, sweet, oatmeal, commercial"));
        twelfthList.add(new RecommendFood(459, "Biscuit, savoury, rice cake, from brown rice, carob coated"));
        twelfthList.add(new RecommendFood(450, "Potato, mashed, dried powder"));
        twelfthList.add(new RecommendFood(1333, "French toast, white bread, plain"));
        twelfthList.add(new RecommendFood(1456, "Dip, pumpkin or sweet potato, commercial"));

        carbohydateData.add(firstList);
        carbohydateData.add(secondList);
        carbohydateData.add(thirdList);
        carbohydateData.add(fourthList);
        carbohydateData.add(fifthList);
        carbohydateData.add(sixthList);
        carbohydateData.add(seventhList);
        carbohydateData.add(eighthList);
        carbohydateData.add(ninethList);
        carbohydateData.add(tenthList);
        carbohydateData.add(eleventhList);
        carbohydateData.add(twelfthList);
    }

    private void initProtein() {
        List<RecommendFood> firstList = new ArrayList<>();
        List<RecommendFood> secondList = new ArrayList<>();
        List<RecommendFood> thirdList = new ArrayList<>();
        List<RecommendFood> fourthList = new ArrayList<>();
        List<RecommendFood> fifthList = new ArrayList<>();
        List<RecommendFood> sixthList = new ArrayList<>();
        List<RecommendFood> seventhList = new ArrayList<>();
        List<RecommendFood> eighthList = new ArrayList<>();
        List<RecommendFood> ninethList = new ArrayList<>();
        List<RecommendFood> tenthList = new ArrayList<>();
        List<RecommendFood> eleventhList = new ArrayList<>();
        List<RecommendFood> twelfthList = new ArrayList<>();
        List<RecommendFood> thirteenthList = new ArrayList<>();
        List<RecommendFood> fourteenthList = new ArrayList<>();
        List<RecommendFood> fifteenthList = new ArrayList<>();
        List<RecommendFood> sixteenthList = new ArrayList<>();
        List<RecommendFood> seventeenthList = new ArrayList<>();
        List<RecommendFood> eighteenthList = new ArrayList<>();
        firstList.add(new RecommendFood(18, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        firstList.add(new RecommendFood(23, "Cheese, for use on crackers or cheese platters"));
        firstList.add(new RecommendFood(14, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        firstList.add(new RecommendFood(14, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        firstList.add(new RecommendFood(14, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        secondList.add(new RecommendFood(56, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        secondList.add(new RecommendFood(71, "Cheese, for use on crackers or cheese platters"));
        secondList.add(new RecommendFood(44, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        secondList.add(new RecommendFood(45, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        secondList.add(new RecommendFood(42, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        thirdList.add(new RecommendFood(91, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        thirdList.add(new RecommendFood(116, "Cheese, for use on crackers or cheese platters"));
        thirdList.add(new RecommendFood(73, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        thirdList.add(new RecommendFood(73, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        thirdList.add(new RecommendFood(70, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        fourthList.add(new RecommendFood(127, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        fourthList.add(new RecommendFood(162, "Cheese, for use on crackers or cheese platters"));
        fourthList.add(new RecommendFood(101, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        fourthList.add(new RecommendFood(102, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        fourthList.add(new RecommendFood(96, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        fifthList.add(new RecommendFood(163, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        fifthList.add(new RecommendFood(208, "Cheese, for use on crackers or cheese platters"));
        fifthList.add(new RecommendFood(130, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        fifthList.add(new RecommendFood(131, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        fifthList.add(new RecommendFood(123, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        sixthList.add(new RecommendFood(199, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        sixthList.add(new RecommendFood(253, "Cheese, for use on crackers or cheese platters"));
        sixthList.add(new RecommendFood(159, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        sixthList.add(new RecommendFood(160, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        sixthList.add(new RecommendFood(150, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        seventhList.add(new RecommendFood(235, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        seventhList.add(new RecommendFood(299, "Cheese, for use on crackers or cheese platters"));
        seventhList.add(new RecommendFood(187, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        seventhList.add(new RecommendFood(189, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        seventhList.add(new RecommendFood(177, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));


        eighthList.add(new RecommendFood(271, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        eighthList.add(new RecommendFood(245, "Cheese, for use on crackers or cheese platters"));
        eighthList.add(new RecommendFood(256, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        eighthList.add(new RecommendFood(218, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        eighthList.add(new RecommendFood(204, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));


        ninethList.add(new RecommendFood(306, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        ninethList.add(new RecommendFood(390, "Cheese, for use on crackers or cheese platters"));
        ninethList.add(new RecommendFood(244, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        ninethList.add(new RecommendFood(246, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        ninethList.add(new RecommendFood(231, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));


        tenthList.add(new RecommendFood(342, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        tenthList.add(new RecommendFood(436, "Cheese, for use on crackers or cheese platters"));
        tenthList.add(new RecommendFood(273, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        tenthList.add(new RecommendFood(275, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        tenthList.add(new RecommendFood(258, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));


        eleventhList.add(new RecommendFood(378, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        eleventhList.add(new RecommendFood(482, "Cheese, for use on crackers or cheese platters"));
        eleventhList.add(new RecommendFood(301, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        eleventhList.add(new RecommendFood(304, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        eleventhList.add(new RecommendFood(285, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));


        twelfthList.add(new RecommendFood(412, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        twelfthList.add(new RecommendFood(527, "Cheese, for use on crackers or cheese platters"));
        twelfthList.add(new RecommendFood(330, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        twelfthList.add(new RecommendFood(333, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        twelfthList.add(new RecommendFood(312, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));


        thirteenthList.add(new RecommendFood(450, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        thirteenthList.add(new RecommendFood(573, "Cheese, for use on crackers or cheese platters"));
        thirteenthList.add(new RecommendFood(359, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        thirteenthList.add(new RecommendFood(361, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        thirteenthList.add(new RecommendFood(339, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        fourteenthList.add(new RecommendFood(486, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        fourteenthList.add(new RecommendFood(619, "Cheese, for use on crackers or cheese platters"));
        fourteenthList.add(new RecommendFood(387, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        fourteenthList.add(new RecommendFood(390, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        fourteenthList.add(new RecommendFood(366, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        fifteenthList.add(new RecommendFood(512, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        fifteenthList.add(new RecommendFood(664, "Cheese, for use on crackers or cheese platters"));
        fifteenthList.add(new RecommendFood(416, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        fifteenthList.add(new RecommendFood(419, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        fifteenthList.add(new RecommendFood(393, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        sixteenthList.add(new RecommendFood(557, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        sixteenthList.add(new RecommendFood(710, "Cheese, for use on crackers or cheese platters"));
        sixteenthList.add(new RecommendFood(444, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        sixteenthList.add(new RecommendFood(448, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        sixteenthList.add(new RecommendFood(420, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        seventeenthList.add(new RecommendFood(593, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        seventeenthList.add(new RecommendFood(756, "Cheese, for use on crackers or cheese platters"));
        seventeenthList.add(new RecommendFood(473, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        seventeenthList.add(new RecommendFood(477, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        seventeenthList.add(new RecommendFood(447, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        eighteenthList.add(new RecommendFood(629, "Mixed seafood, contains fish & shellfish, baked, roasted, fried, grilled or BBQ'd, with or without added fat"));
        eighteenthList.add(new RecommendFood(801, "Cheese, for use on crackers or cheese platters"));
        eighteenthList.add(new RecommendFood(501, "Chicken, breast, flesh, fried or stir-fried, no added fat"));
        eighteenthList.add(new RecommendFood(506, "Beef, diced, fully-trimmed, boiled, casseroled, microwaved, poached, steamed or stewed, no added fat"));
        eighteenthList.add(new RecommendFood(474, "Pork, loin roast, fully-trimmed, boiled, casseroled, microwaved, poached, steamed, or stewed, no added fat"));

        proteinData.add(firstList);
        proteinData.add(secondList);
        proteinData.add(thirdList);
        proteinData.add(fourthList);
        proteinData.add(fifthList);
        proteinData.add(sixthList);
        proteinData.add(seventhList);
        proteinData.add(eighthList);
        proteinData.add(ninethList);
        proteinData.add(tenthList);
        proteinData.add(eleventhList);
        proteinData.add(twelfthList);
        proteinData.add(thirteenthList);
        proteinData.add(fifteenthList);
        proteinData.add(fourteenthList);
        proteinData.add(seventeenthList);
        proteinData.add(sixteenthList);
        proteinData.add(eighteenthList);
    }

    private void initFat() {
        List<RecommendFood> firstList = new ArrayList<>();
        List<RecommendFood> secondList = new ArrayList<>();
        List<RecommendFood> thirdList = new ArrayList<>();
        List<RecommendFood> fourthList = new ArrayList<>();
        List<RecommendFood> fifthList = new ArrayList<>();
        List<RecommendFood> sixthList = new ArrayList<>();
        firstList.add(new RecommendFood(24, "Avocado, raw"));
        firstList.add(new RecommendFood(28, "Cheese, mozzarella, reduced fat"));
        firstList.add(new RecommendFood(16, "Egg, chicken, yolk, hard-boiled"));
        firstList.add(new RecommendFood(104, "Bread, from white flour, chia seeds, commercial, toasted"));
        firstList.add(new RecommendFood(13, "Chocolate, milk, with nuts"));

        secondList.add(new RecommendFood(74, "Avocado, raw"));
        secondList.add(new RecommendFood(86, "Cheese, mozzarella, reduced fat"));
        secondList.add(new RecommendFood(49, "Egg, chicken, yolk, hard-boiled"));
        secondList.add(new RecommendFood(323, "Bread, from white flour, chia seeds, commercial, toasted"));
        secondList.add(new RecommendFood(39, "Chocolate, milk, with nuts"));

        thirdList.add(new RecommendFood(121, "Avocado, raw"));
        thirdList.add(new RecommendFood(142, "Cheese, mozzarella, reduced fat"));
        thirdList.add(new RecommendFood(80, "Egg, chicken, yolk, hard-boiled"));
        thirdList.add(new RecommendFood(531, "Bread, from white flour, chia seeds, commercial, toasted"));
        thirdList.add(new RecommendFood(64, "Chocolate, milk, with nuts"));


        fourthList.add(new RecommendFood(169, "Avocado, raw"));
        fourthList.add(new RecommendFood(198, "Cheese, mozzarella, reduced fat"));
        fourthList.add(new RecommendFood(112, "Egg, chicken, yolk, hard-boiled"));
        fourthList.add(new RecommendFood(740, "Bread, from white flour, chia seeds, commercial, toasted"));
        fourthList.add(new RecommendFood(89, "Chocolate, milk, with nuts"));

        fifthList.add(new RecommendFood(217, "Avocado, raw"));
        fifthList.add(new RecommendFood(254, "Cheese, mozzarella, reduced fat"));
        fifthList.add(new RecommendFood(112, "Egg, chicken, yolk, hard-boiled"));
        fifthList.add(new RecommendFood(740, "Bread, from white flour, chia seeds, commercial, toasted"));
        fifthList.add(new RecommendFood(89, "Chocolate, milk, with nuts"));

        sixthList.add(new RecommendFood(264, "Avocado, raw"));
        sixthList.add(new RecommendFood(310, "Cheese, mozzarella, reduced fat"));
        sixthList.add(new RecommendFood(175, "Egg, chicken, yolk, hard-boiled"));
        sixthList.add(new RecommendFood(1156, "Bread, from white flour, chia seeds, commercial, toasted"));
        sixthList.add(new RecommendFood(140, "Chocolate, milk, with nuts"));

        fatData.add(firstList);
        fatData.add(secondList);
        fatData.add(thirdList);
        fatData.add(fourthList);
        fatData.add(fifthList);
        fatData.add(sixthList);

    }
}
