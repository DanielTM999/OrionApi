package dtm.ide.api.extension;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public interface Resource {
    Path getResourcePath();

    Path getResourcePath(String path);

    Path getResourcePath(Path path);


    URL getResource(String name);
    List<URL> getResources(Collection<String> name);

    InputStream getResourceAsStream(String name);
    List<InputStream> getResourcesAsStreams(Collection<String> name);

    Path getSharedResourcePath();

    URL getSharedResource(String name);
    List<URL> getSharedResources(Collection<String> name);

    InputStream getSharedResourceAsStream(String name);
    List<InputStream> getSharedResourcesAsStreams(Collection<String> name);

}
