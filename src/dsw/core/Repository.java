package dsw.core;

import dsw.repository.Workspace;

public interface Repository {
    Workspace getWorkspace();
    void setWorkspace(Workspace workspace);
}
