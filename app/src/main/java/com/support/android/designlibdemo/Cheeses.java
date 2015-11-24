/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * This class DATA storage. - artificial data for our project.
 */

package com.support.android.designlibdemo;

import java.util.Random;

public class Cheeses {

    private static final Random RANDOM = new Random();

    public static int getRandomCheeseDrawable() {
        switch (RANDOM.nextInt(2)) {
            default:
            case 0:
                return R.drawable.cheese_1;
            case 1:
                return R.drawable.cheese_2;
            case 2:
                return R.drawable.cheese_3;
            case 3:
                return R.drawable.cheese_4;
            case 4:
                return R.drawable.cheese_5;
        }
    }

    public static final String[] sCheeseStrings = {
            "IN001 - WOOD - 55.778 t",
            "IN002 - OIL - 955.72 t",
            "IN003 - SAND - 5005.789 t",
            "IN004 - ROCK - 525.790 t",
            "OUT001 - OIL - 89.6 l",
            "OUT002 - WOOD - 1255.7 t",
            "OUT003 - ROCK - 1155.7 t",
            "OUT004 - SAND - 155.7 t",
    };

}
