package dsw.repository;

import dsw.core.Repository;

public class RepositoryImpl implements Repository {

    private Workspace root;

    public RepositoryImpl(){
        this.root = new Workspace("Workspace");
    }

    public void setRoot(Workspace root) {
        this.root = root;
    }

    @Override
    public Workspace getWorkspace() {
        return root;
    }

    @Override
    public void setWorkspace(Workspace workspace) {
        this.root = workspace;
    }
}
