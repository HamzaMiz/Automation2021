package mobile.iOS.agnet;

import framework.Branding;
import mobile.iOS.NonRegIos;
import org.testng.annotations.Listeners;


@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })
public class NonRegAgnet extends NonRegIos {


    public NonRegAgnet() {
        super(Branding.AGNET);

    }
}