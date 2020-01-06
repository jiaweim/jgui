/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package trail.jgui.javafx.binding;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.20, 9:36 AM
 */
public class Monitor {

    public static final String DEFAULT_SCREEN_TYPE = "flat";
    private StringProperty screenType;

    public String getScreenType() {
        return (screenType == null) ? DEFAULT_SCREEN_TYPE : screenType.get();
    }

    public void setScreenType(String newScreenType) {
        if (screenType != null || !DEFAULT_SCREEN_TYPE.equals(newScreenType)) {
            screenTypeProperty().set(newScreenType);
        }
    }

    public StringProperty screenTypeProperty() {
        if (screenType == null) {
            screenType = new SimpleStringProperty(this, "screenType", DEFAULT_SCREEN_TYPE);
        }
        return screenType;
    }

}
