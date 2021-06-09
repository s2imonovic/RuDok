package dsw.guiSwing.view.state;

import dsw.guiSwing.view.repositoryView.PageView;

public class StateManager {

    private State currentState;
    private CircleState circleState;
    private RectangleState rectangleState;
    private TriangleState triangleState;
    private SelectState selectState;
    private MoveState moveState;
    private ResizeState resizeState;
    private RotateState rotateState;
    private DeleteState deleteState;
    private LassoState lassoState;

    public StateManager(PageView view){
        circleState = new CircleState(view);
        rectangleState = new RectangleState(view);
        triangleState = new TriangleState(view);
        selectState = new SelectState(view);
        moveState = new MoveState(view);
        resizeState = new ResizeState(view);
        rotateState = new RotateState(view);
        deleteState = new DeleteState(view);
        lassoState = new LassoState(view);
        currentState = selectState;
    }

    public void setCircleState() {
        currentState = circleState;
    }

    public void setRectangleState() {
        currentState = rectangleState;
    }

    public void setTriangleState() {
        currentState = triangleState;
    }

    public void setSelectState() {
        currentState = selectState;
    }

    public void setMoveState() {
        currentState = moveState;
    }

    public void setResizeState() {
        currentState = resizeState;
    }

    public void setRotateState() {
        currentState = rotateState;
    }

    public void setDeleteState() {
        currentState = deleteState;
    }

    public void setLassoState() {
        currentState = lassoState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
