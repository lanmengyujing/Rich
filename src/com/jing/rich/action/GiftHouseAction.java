package com.jing.rich.action;

import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;
import com.jing.rich.CommandParser;
import com.jing.rich.exception.CommandNotFoundException;
import com.jing.rich.ground.Ground;
import com.jing.rich.tools.GiftCard;

public class GiftHouseAction extends AbstractReachPlaceAction {
    public GiftHouseAction(Player player, Ground ground) {
        super(player, ground);
    }

    public void action() {
        IO.writeTo(Phrases.GIFT_HOUSE_TIP);
        IO.writeTo(Phrases.INPUT_TIP);
        CommandParser parser = new CommandParser();
        String commandStr = IO.readLine();
        try {
            int num = parser.parseGiftCommand(commandStr);
            parseGift(num);
        } catch (NumberFormatException e) {
            IO.writeTo(Phrases.WRONG_SELECTION);
        } catch (CommandNotFoundException e) {
            IO.writeTo(Phrases.WRONG_SELECTION);
        }

    }

    private void parseGift(int num) {
        GiftCard giftCard = null;
        String giftTip = null;
        switch (num) {
            case 1:
                giftCard = GiftCard.BONUSCARD;
                giftTip = Phrases.BOUNUS_TIP;
                break;
            case 2:
                giftCard = GiftCard.POINTSCARD;
                giftTip = Phrases.POINTS_TIP;
                break;
            case 3:
                giftCard = GiftCard.FUSHENCARD;
                giftTip = Phrases.FUSHEN_TIP;
                break;
            default:
                throw new AssertionError();
        }
        player.addGiftCard(giftCard);
        IO.writeTo(giftTip);
    }
}
