/*
    @author: Abraham Hernandez - TSOFT
*/
package com.niubiz.bot.frontend.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sleeper {

    private static final Logger logger = LogManager.getLogger(Sleeper.class);

    private Sleeper() {
    }

    private static final double ESCALA = 1.8;

    public static void sleep(int tiempo) {
        try {
            if (tiempo <= 0) return;
            Thread.sleep((long) (tiempo * ESCALA));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("sleep: " + e.getMessage());
        }
    }
}