package util;

import java.util.ArrayList;

public abstract class ModelEcoutable {

	protected ArrayList<EcouteurModel>ecouteurs;
	public ModelEcoutable() {
		
		this.ecouteurs=new ArrayList<>();
	}
	
	
	public void ajoutEcouteur(EcouteurModel e) {
		
		this.ecouteurs.add(e);
	}

	
	public void retraitEcouteur(EcouteurModel e) {
		
		this.ecouteurs.remove(e);
	}
	
	public void fireChangement() {
		for(EcouteurModel e :ecouteurs) {
			e.modeleMisAJour(this);
		}
		
	}
}
