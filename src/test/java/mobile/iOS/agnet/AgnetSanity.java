package mobile.iOS.agnet;

import framework.Branding;
import mobile.iOS.IOSSanity;
import org.testng.annotations.Listeners;

@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })
public class AgnetSanity extends IOSSanity {
    public AgnetSanity() {
        super(Branding.AGNET);
        
    }



}