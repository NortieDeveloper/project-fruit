package com.bittoastergames.projectfruit.main;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.io.IOException;
import java.net.MalformedURLException;

public class FruitConectionHandler {

    int updateChecked = 0;

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {

        try {
            if (UpdateCheck.isUpdateAvailable()) {
                if (updateChecked == 0) {
                    event.player.addChatMessage(new ChatComponentText("["
                            + EnumChatFormatting.YELLOW
                            + "Project Fruit"
                            + EnumChatFormatting.RESET
                            + "] An update is available for this mod. Check www.bittoastergames.com for more info. (Your Version: "
                            + EnumChatFormatting.YELLOW
                            + ProjectFruit.version
                            + EnumChatFormatting.RESET
                            + " Latest Version: "
                            + EnumChatFormatting.YELLOW
                            + UpdateCheck.getNewVersion()
                            + EnumChatFormatting.RESET
                            + ")"));
                    updateChecked++;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

