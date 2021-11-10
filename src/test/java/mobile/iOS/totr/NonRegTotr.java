package mobile.iOS.totr;

import framework.Branding;
import mobile.iOS.NonRegIos;
import org.testng.annotations.Listeners;

@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })
public class NonRegTotr extends NonRegIos {


    public NonRegTotr() {
        super(Branding.TOTR);    }

}

