package mobile.android.agnet;

import framework.Branding;
import mobile.android.AndroidSanity;
import org.testng.annotations.Listeners;

@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })
public class AgnetSanity extends AndroidSanity {


    public AgnetSanity() {
        super(Branding.AGNET);
    }
}