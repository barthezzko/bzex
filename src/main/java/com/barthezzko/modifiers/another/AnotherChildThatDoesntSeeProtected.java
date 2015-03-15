package com.barthezzko.modifiers.another;

import com.barthezzko.modifiers.Child;

/**
 * Created by barthezzko on 11.03.2015.
 */
public class AnotherChildThatDoesntSeeProtected {

    public void cantSee(){
        Child child  = new Child();
        //child.doSmth();
    }

}
