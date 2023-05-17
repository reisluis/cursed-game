package org.academiadecodigo.powrangers;


import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_ENTER;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;

public class InitGame implements KeyboardHandler {

    Keyboard keyboard = new Keyboard(this);
    private boolean enterNotPressed = true;



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KEY_ENTER);
        enter.setKeyboardEventType(KEY_PRESSED);
        keyboard.addEventListener(enter);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KEY_ENTER:
                enterNotPressed = false;
                break;
        }
    }
}
