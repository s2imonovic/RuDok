package dsw.core;

import dsw.repository.Project;
import dsw.repository.Workspace;

import java.io.File;

public interface Serialization {

    void openProject(Project project);
    void saveProject(Project project, File projectFile);
    void saveWorkspace(Workspace workspace, File workspaceFile);

}
