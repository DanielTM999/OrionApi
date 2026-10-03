package dtm.ide.api.extension.terminal;

import java.util.List;

@FunctionalInterface
public interface TerminalLinkProvider {

    List<TerminalLink> findLinks(String line);
}
