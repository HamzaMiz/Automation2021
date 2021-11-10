package mobile.iOS.totr;

import framework.Branding;
import mobile.iOS.IOSSanity;
import org.testng.annotations.Listeners;

@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })
public class TotrSanity extends IOSSanity {

    public TotrSanity() {
        super(Branding.TOTR);
    }


}
