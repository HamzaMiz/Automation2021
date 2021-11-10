package mobile.iOS;

import framework.Platforms;
import mobile.NonRegression;
import org.testng.annotations.Listeners;

@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })

public class NonRegIos extends NonRegression {


    public NonRegIos(String branding) {

        super(Platforms.IOS, branding);
    }

}