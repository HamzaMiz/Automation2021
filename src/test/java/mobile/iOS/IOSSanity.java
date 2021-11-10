package mobile.iOS;

import mobile.STWSanity;
import framework.Platforms;
import org.testng.annotations.Listeners;

@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })

public class IOSSanity extends STWSanity {


    public IOSSanity(String branding) {
        super(Platforms.IOS, branding);
    }
    
}
