package View;

import java.util.concurrent.Semaphore;

import controller.ThreadsCorredores;

public class corredores {

	public static void main(String[] args) {
		
		int permissoes=1;
		Semaphore semaforo = new Semaphore (permissoes);
		for (int idAtleta=0;idAtleta<4;idAtleta++) {
			Thread corrida = new ThreadsCorredores(idAtleta,semaforo);
			corrida.start();
		}

	}

}
