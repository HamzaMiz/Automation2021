package mobile.android.totr;

import framework.Branding;
import mobile.android.AndroidSanity;
import org.testng.annotations.Listeners;

@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })
public class TotrSanity extends AndroidSanity {

    public TotrSanity() {
        super(Branding.TOTR);
    }
}
