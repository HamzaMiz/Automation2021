package mobile.android;

import framework.Platforms;
import mobile.STWSanity;
import org.testng.annotations.Listeners;

@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })
public class AndroidSanity  extends STWSanity {
    public AndroidSanity( String branding) {
        super(Platforms.ANDROID, branding);
    }



}
