package controller;

import java.util.concurrent.Semaphore;

public class ThreadsCorredores extends Thread {

	private int idAtleta;
	private static int chegada;
	private Semaphore semaforo;

	public ThreadsCorredores(int idAtleta, Semaphore semaforo) {
		this.idAtleta = idAtleta;
		this.semaforo=semaforo;
	}

	public void run() {
		atletaCorrendo();
		try {
			semaforo.acquire();
			atletaEntrando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
		semaforo.release();
		}
	}

	private void atletaCorrendo() {
		int distTotal = 200;
		int distPercorrida = 0;
		int deslocamento = 10;
		int tempo = (int) ((Math.random()*401)+600);
		while (distPercorrida < distTotal) {
			distPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("#" +idAtleta+"já andou" +distPercorrida+".m");
		}
		
	}

	private void atletaEntrando() {
		System.out.println("#" +idAtleta + "chegou na porta");
		int tempo = (int) ((Math.random()*101)+200);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chegada++;
		System.err.println("#Atleta:" +idAtleta + " foi o "+ chegada+ "° a passar pela porta");
	}

}
