package com.jing.rich;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-28
 * Time: 下午9:08
 * To change this template use File | Settings | File Templates.
 */
public class Phrases {

    public static final String QIANFUREN = "钱夫人";
    public static final String QIANFUREN_CODE = "Q";
    public static final String ATUBO = "阿土伯";
    public static final String ATUBO_CODE = "A";
    public static final String SUNXIAOMEI = "孙小美";
    public static final String SUNXIAOMEI_CODE = "S";
    public static final String JINBEIBEI = "金贝贝";
    public static final String JINBEIBEI_CODE = "J";

    static int priceList[] = {200, 500, 300};
    static int pointList[] = {20, 80, 100, 40, 80, 60};
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
    public static final String YES = "y";
    public static final String NO = "n";
    public static final String CANNOT_UPDATE_LAND_NOT_OWN = "对不起，此处不是您的房屋，无法升级！";

    public static final String GIFT_HOUSE_TIP = "欢迎光临礼品屋，请选择一件您喜欢的礼品：" +
                                                    "奖金      1\n" +
                                                    "点数卡   2\n" +
                                                    "福 神      3";
    public static final String FUSEHNCARD = "福神卡";
    public static final String POINTSCARD = "点数卡";
    public static final String BONUSCARD = "奖金";
    public static final String FUSHEN_TIP = "福神俯神，可免过路费";
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
    public static final int[] pointsList = {20, 80, 100, 40, 80, 60};

    public static final String GET_POINTS = "恭喜您，路过矿地，获得点数";
    public static final String TOOLHOUSE_WELCOME = "欢迎光临道具屋， 请选择您所需要的道具：";
    public static final String TOOLHOUSE_TIPS = "通过输入道具的编号选择道 具，每位玩家最多可以拥有10个道具。\n"+
            "道具        编号    价值（点数）    显示方式\n"+
            "路障          1        50         ＃\n"+
            "机器娃娃      2        30            \n"+
            "炸 弹         3        50          @" ;
}
