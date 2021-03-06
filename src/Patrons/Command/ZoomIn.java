package Patrons.Command;

public class ZoomIn implements Command {
	private double zoomValue;
	private double nZoom;
	private double oDragX;
	private double oDragY;

	public ZoomIn (double zoomValue){
		setZoomValue(zoomValue-model.getZoom());
	}

	public ZoomIn() {
		setZoomValue(DEFAULT_ZOOM);
	}

	@Override
	public boolean execute() {
		if(model.getImage() != null){
			nZoom = model.getZoom()+zoomValue;
			oDragX = model.getDragX();
			oDragY = model.getDragY();

			return model.changeModelImage(nZoom, model.getDragX(), model.getDragY());
		}else{
			return false;
		}
	}

	@Override
	public void reDo() {
		execute();
	}

	@Override
	public void unDo() {
		nZoom = model.getZoom()-zoomValue;
		model.changeModelImage(nZoom, 0, 0);
		model.changeModelImage(model.getZoom(), oDragX, oDragY);
	}

	public void setZoomValue(double zoomValue) {
		this.zoomValue = zoomValue;
	}
}



