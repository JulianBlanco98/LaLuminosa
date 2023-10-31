package com.example.BD_ejemplo.model;

public class Tablero {

	private int fila = 4;
	private int columna = 13;
	private Celda[][] tablero;

	public Tablero() {

		tablero = new Celda[fila][columna];
	}

	public void inicializarMatriz() {

		int aux1 = 3;
		int aux2 = 2;
		int aux3 = 1;

		// System.out.println("asdasd");
		for (int i = 0; i < fila - 1; i++) {
			for (int j = 1; j < columna; j++) {

				tablero[i][j] = new Celda(); // Inicialicamos a constructor por defecto
				tablero[i][j].setTipo(1); // Tipo 0: es un número

				// Rellenamos los valores
				if (i == 0) {
					tablero[i][j].setValor(aux1);
					aux1 = aux1 + 3;
					if (tablero[i][j].getValor() % 2 == 0) {
						tablero[i][j].setColor("rojo");
					} else {
						tablero[i][j].setColor("negro");
					}
				}
				if (i == 1) {
					tablero[i][j].setValor(aux2);
					aux2 = aux2 + 3;

				}
				if (i == 2) {
					tablero[i][j].setValor(aux3);
					aux3 = aux3 + 3;
					if (tablero[i][j].getValor() % 2 == 0) {
						tablero[i][j].setColor("negro");
					} else {
						tablero[i][j].setColor("rojo");
					}
				}

				// Rellenamos Par e Impar
				if (tablero[i][j].getValor() % 2 == 0) {
					tablero[i][j].setEspar(true);
				} else {
					tablero[i][j].setEspar(false);
				}

			}

		}

		// Ponemos a la fila 2, combinación de 2 en 2 de colores
		String color = "rojo";
		for (int j = 1; j < columna; j += 2) {

			tablero[1][j].setColor(color);
			tablero[1][j + 1].setColor(color);

			if (color.equals("rojo")) {
				color = "negro";
			} else {
				color = "rojo";
			}
		}

		for (int i = 0; i < fila - 1; i++) {
			tablero[i][0] = new Celda();
			tablero[i][0].setValor(0);
			tablero[i][0].setColor("verde");
			tablero[i][0].setTipo(0);
		}

	}

	public void imprimirValor() {
		for (int i = 0; i < fila - 1; i++) {
			for (int j = 0; j < columna; j++) {
				System.out.print("| " + tablero[i][j].getValor() + " | ");
			}
			System.out.println();
		}
	}

	public void imprimirColor() {
		for (int i = 0; i < fila - 1; i++) {
			for (int j = 0; j < columna; j++) {
				System.out.print("| " + tablero[i][j].getColor() + " | ");
			}
			System.out.println();
		}
	}

	public void imprimirpParImopar() {
		for (int i = 0; i < fila - 1; i++) {
			for (int j = 0; j < columna; j++) {
				try {
					System.out.print("| " + tablero[i][j].isEspar() + " | ");
				} catch (NullPointerException e) {
					System.out.print("| null | ");
				}
			}
			System.out.println();
		}
	}
	public void imprimirTipo() {
		for (int i = 0; i < fila - 1; i++) {
			for (int j = 0; j < columna; j++) {
				System.out.print("| " + tablero[i][j].getTipo() + " | ");
			}
			System.out.println();
		}
	}
	

	public Tablero(int fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

}
