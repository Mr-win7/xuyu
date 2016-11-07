package net.bingyan.xuyu.domain;

import java.util.List;

public class MomentWithPhotos
{
	private Moment moment;

	private List<MomentPhoto> momentPhotos;

	public Moment getMoment()
	{
		return moment;
	}

	public void setMoment(Moment moment)
	{
		this.moment = moment;
	}

	public List<MomentPhoto> getMomentPhotos()
	{
		return momentPhotos;
	}

	public void setMomentPhotos(List<MomentPhoto> momentPhotos)
	{
		this.momentPhotos = momentPhotos;
	}
}