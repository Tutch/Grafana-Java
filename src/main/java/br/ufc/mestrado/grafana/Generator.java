package br.ufc.mestrado.grafana;

import java.util.Timer;
import java.util.TimerTask;
import br.ufc.mestrado.grafana.DatabaseInterface;

public class Generator {
	// Tempo de espera em ms
	private static final int SLEEP = 30000;
	private static final int MIN = 0;
	private static final int MAX = 100;
	private static DatabaseInterface dbinterface;
	
	public static void main(String args[]) {
		Timer grafana_wait = new Timer();
		dbinterface = new DatabaseInterface();
		
		grafana_wait.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				dbinterface.createRandom(MIN, MAX);
			}
		}, SLEEP, SLEEP);
	}
}
