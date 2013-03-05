package com.jing.rich;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-06
 * Time: 下午9:08
 * To change this template use File | Settings | File Templates.
 */
public class Phrases {
    public static final int GROUND_COUNT = 70;
    public static final String QIANFUREN = "钱夫人";
    public static final String QIANFUREN_CODE = "Q";
    public static final String ATUBO = "阿土伯";
    public static final String ATUBO_CODE = "A";
    public static final String SUNXIAOMEI = "孙小美";
    public static final String SUNXIAOMEI_CODE = "S";
    public static final String JINBEIBEI = "金贝贝";
    public static final String JINBEIBEI_CODE = "J";

    static int priceList[] = {200, 500, 300};
    public static final int[] pointsList = {20, 80, 100, 40, 80, 60};
    public static final String UPDATE_TOO_MUCH = "对不起，房子已是摩天楼，无法再升级!";
    public static final String CASH_SET_TIPS = "请设置玩家初始资金，范围1000～50000（输入e，则默认设置为10000）:";
    public static final String WRONG_INIT_CASH = "您设置的资金有误，请重新输入：";
    public static final String SELECT_PLAYER_TIP = "请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):”：如输入12。";

    public static final String COMMAND_PREFIX ="->待输入命令：" ;
    public static final String[] COMMAND_LIST ={"roll", "block", "bomb", "robot", "sell", "sellTool", "query", "help", "quit"} ;
    public static final String WRONG_COMMAND = "对不起，您输入的指令有误，请重新输入：";
    public static final String HUIHE_JIESU = " 回合结束！";
    public static final String WRONG_INIT_FOR_PLAYER = "对不起，玩家设置输入错误，请重新输入：";
    public static final String OPENSPACE_TOBUY = "是否购买该处空地，";
    public static final String OPENSPACE_TOBUY_UNIT = "元（Y/N）?";
    public static final String BUY_LAND_SUCCESS = "您成功购买了";
    public static final String BUY_LAND_SUCCESS_AFTER = "号空地";
    public static final String YES = "y";
    public static final String NO = "n";

    public static final String UPDATE_LAND_TIP = "是否升级该处地产，";
    public static final String UPDATE_UNIT = "元（Y/N）?";
    public static final String LAND_LEVEL = "房屋总共分为三级，每升一级的费用同购买空地的费用，各级符号如下：\n"+
                                                    "空地     0\n"+
                                                    "茅屋     1\n"+
                                                    "洋房     2\n"+
                                                    "摩天楼   3" ;
    public static final String OPENSPACE = "空地";
    public static final String MAO_WU = "茅屋";
    public static final String YANG_LOU = "洋房";
    public static final String MO_TIAN_LOU = "摩天楼";
    public static final String CANNOT_UPDATE_LAND_NOT_OWN = "对不起，此处不是您的房屋，无法升级！";
    public static final String UPDATE_LAND_SUCCESS = "房屋成功升级为";

    public static final String GIFT_HOUSE_TIP = "欢迎光临礼品屋，请选择一件您喜欢的礼品：\n" +
                                                    "通过输入礼品编号选择礼品：\n" +
                                                    "礼品    编号\n"+
                                                    "奖金     1\n" +
                                                    "点数卡   2\n" +
                                                    "福 神    3";
    public static final String INPUT_TIP = "请输入一个礼品编号，选择一件您喜欢的礼品：";
    public static final String SELECTED_GIFT = "您获得了";
    public static final String GIFT_FUSEHNCARD = "福神卡";
    public static final String GIFT_POINTSCARD = "点数卡";
    public static final String GIFT_BONUSCARD = "奖金";
    public static final String BOUNUS_TIP = "恭喜，您获得奖金2000元！";
    public static final String POINTS_TIP = "恭喜，您获得200点！";
    public static final String FUSHEN_TIP = "恭喜，您获得福神卡一张，" +
            "路过其它玩家地盘，均可免费。5轮内有效（在监狱、医院中也计轮次）。";
    public static final String FUSHEN_USE = "福神俯神，可免过路费";
    public static final String ROLL_TIP_PRE = "路过";
    public static final String ROLL_TIP = "的土地，需交过路费";
    public static final String GET_ROLL_TIP = "得到过路费";
    public static final String PAY_ROLL_TIP = "缴纳过路费";
    public static final String MONEY_UNIT = "元";
    public static final String OWNER_IN_H = "主人正在医院，可免过路费";
    public static final String OWNER_IN_P ="主人正在监狱，可免过路费" ;
    public static final String IN_PRISON_TIP = "非常不幸，您走进了监狱，将被拘留2天。";
    public static final String LUN_KONG = "本轮被轮空，无法操作！";
    public static final String WRONG_SELECTION = "对不起，输入错误，本次没有选择任何礼品，自动退出礼品屋！";

    public static final String GET_POINTS = "恭喜您，路过矿地，获得点数";
    public static final String TOOLHOUSE_WELCOME = "欢迎光临道具屋， 请选择您所需要的道具：";
    public static final String TOOLHOUSE_TIPS = "通过输入道具的编号选择道具，每位玩家最多可以拥有10个道具。\n"+
            "道具        编号    价值（点数）    显示方式\n"+
            "路障          1        50         ＃\n"+
            "机器娃娃      2        30          * \n"+
            "炸 弹         3        50          @" ;
    public static final int MIN_POINTS = 30;
    public static final String TOOLHOUSE_EXIT_TIPS = "若不想购买，按F键，可退出道具屋。";
    public static final String AFTER_EXIT = "您选择退出了道具屋。";
    public static final String TOOLHOUSE_SELECT_TIPS = "请输入一个编号,选择您希望购买的道具：";
    public static final String SELECTED_PROP = "您成功购买了1个";
    public static final String POINTS_NOT_ENOUGH = "您当前的点数不足买点数最少的道具，自动退出道具屋！";
    public static final String EXIT = "f";
    public static final String NOT_ENOUGH_TIP1 = "您当前剩余的点数为";
    public static final String NOT_ENOUGH_TIP2 = "元，不足以购买";
    public static final String PROP = "道具";
    public static final String ROAD_NAME = "路障";
    public static final String ROAD_SYMBOL = "#";
    public static final String BOMB_NAME = "炸弹" ;
    public static final String BOMB_SYMBOL = "@";
    public static final String ROBOT_NAME = "机器娃娃";
    public static final String ROBOT_SYMBOL = "*";
    public static final int MAX_PROP_COUNT = 10;
    public static final String HAVE_MAX_PROP = "对不起，您最多可以拥有10个道具。将自动退出道具屋。";

    public static final String MAGIC_HOUSE_TIP = "对不起，魔法师外出度假中，暂时不提供魔法。" ;


    public static final String SOLD_TIP = "房屋被成功出售！";
    public static final String WRONG_SELL = "此地非您所有，无法出售！";
}
