package game;

public class BoardModel {
	//test
	public static final int MIN_SIZE = 8;
	public static final int MEDIUM_SIZE = 12;
	public static final int MAX_SIZE = 16;

	public int size;
	public EFieldState[][] fields;
	public EPlayerColor currentPlayer;

	public BoardModel(int size) {

		this.currentPlayer = EPlayerColor.RED_1;
		this.size = size;
		this.fields = new EFieldState[size][size];
	}

	public boolean placeStone(int x, int y) {
		
		//TODO Check if the stone was indeed placed.
		//This is not sure as we have to check if placement was possible.
		//Return the new current player.
		
		System.out.println("Added " + x + " " + y);
		if (currentPlayer == EPlayerColor.RED_1) {
			fields[x][y] = EFieldState.RED;
			currentPlayer = EPlayerColor.BLUE_2;
			return true;
		} else if (currentPlayer == EPlayerColor.BLUE_2) {
			fields[x][y] = EFieldState.BLUE;
			currentPlayer = EPlayerColor.RED_1;
			return true;
		}
		return false;
	}
	
	public void invertStones(int x, int y, EPlayerColor Player) {
		
		north(x, y, Player);
		south(x, y, Player);
		west(x, y, Player);
		east(x, y, Player);
		northWest(x, y, Player);
		northEast(x, y, Player);
		southWest(x, y, Player);
		southEast(x, y, Player);
		
	}
	
	private void southWest(int x, int y, EPlayerColor Player) {
		
		while(fields[x][y] != fields[x+1][y-1] && fields[x+1][y-1] != EFieldState.EMPTY) {
			x = x+1;
			y = y-1;
		}
		
		while(fields[x][y] != fields[x-1][y+1] && fields[x-1][y+1] != EFieldState.EMPTY) {
			if (Player == EPlayerColor.RED_1) {
				fields[x][y] = EFieldState.BLUE;
			} else if (Player == EPlayerColor.BLUE_2) {
				fields[x][y] = EFieldState.RED;
			}
			x = x-1;
			y = y+1;
		}
	}
	
	private void southEast(int x, int y, EPlayerColor Player) {
		
		while(fields[x][y] != fields[x+1][y+1] && fields[x+1][y+1] != EFieldState.EMPTY) {
			x = x+1;
			y = y+1;
		}
		
		while(fields[x][y] != fields[x-1][y-1] && fields[x-1][y-1] != EFieldState.EMPTY) {
			if (Player == EPlayerColor.RED_1) {
				fields[x][y] = EFieldState.BLUE;
			} else if (Player == EPlayerColor.BLUE_2) {
				fields[x][y] = EFieldState.RED;
			}
			x = x-1;
			y = y-1;
		}
	}
	
	private void northWest(int x, int y, EPlayerColor Player) {
		
		while(fields[x][y] != fields[x-1][y-1] && fields[x-1][y-1] != EFieldState.EMPTY) {
			x = x-1;
			y = y-1;
		}
		
		while(fields[x][y] != fields[x+1][y+1] && fields[x+1][y+1] != EFieldState.EMPTY) {
			if (Player == EPlayerColor.RED_1) {
				fields[x][y] = EFieldState.BLUE;
			} else if (Player == EPlayerColor.BLUE_2) {
				fields[x][y] = EFieldState.RED;
			}
			x = x+1;
			y = y+1;
		}
	}
	
	private void northEast(int x, int y, EPlayerColor Player) {
		
		while(fields[x][y] != fields[x-1][y+1] && fields[x-1][y+1] != EFieldState.EMPTY) {
			x = x-1;
			y = y+1;
		}
		
		while(fields[x][y] != fields[x+1][y-1] && fields[x+1][y-1] != EFieldState.EMPTY) {
			if (Player == EPlayerColor.RED_1) {
				fields[x][y] = EFieldState.BLUE;
			} else if (Player == EPlayerColor.BLUE_2) {
				fields[x][y] = EFieldState.RED;
			}
			x = x+1;
			y = y-1;
		}
	}
	
	private void north(int x, int y, EPlayerColor Player) {
		
		while(fields[x][y] != fields[x-1][y] && fields[x-1][y] != EFieldState.EMPTY) {
			x = x-1;
		}
		
		while(fields[x][y] != fields[x][y+1] && fields[x][y+1] != EFieldState.EMPTY) {
			if (Player == EPlayerColor.RED_1) {
				fields[x][y] = EFieldState.BLUE;
			} else if (Player == EPlayerColor.BLUE_2) {
				fields[x][y] = EFieldState.RED;
			}
			x = x+1;
		}
	}
	
	private void east(int x, int y, EPlayerColor Player) {
		
		while(fields[x][y] != fields[x][y+1] && fields[x][y+1] != EFieldState.EMPTY) {
			y = y+1;
		}
		
		while(fields[x][y] != fields[x][y-1] && fields[x][y-1] != EFieldState.EMPTY) {
			if (Player == EPlayerColor.RED_1) {
				fields[x][y] = EFieldState.BLUE;
			} else if (Player == EPlayerColor.BLUE_2) {
				fields[x][y] = EFieldState.RED;
			}
			y = y-1;
		}
	}
	
	private void west(int x, int y, EPlayerColor Player) {
		
		while(fields[x][y] != fields[x][y-1] && fields[x][y-1] != EFieldState.EMPTY) {
			y = y-1;
		}
		
		while(fields[x][y] != fields[x][y+1] && fields[x][y+1] != EFieldState.EMPTY) {
			if (Player == EPlayerColor.RED_1) {
				fields[x][y] = EFieldState.BLUE;
			} else if (Player == EPlayerColor.BLUE_2) {
				fields[x][y] = EFieldState.RED;
			}
			y = y+1;
		}
	}
	
	private void south(int x, int y, EPlayerColor Player) {
		
		while(fields[x][y] != fields[x+1][y] && fields[x+1][y] != EFieldState.EMPTY) {
			x=x+1;
		}
		
		while(fields[x][y] != fields[x][y-1] && fields[x][y-1] != EFieldState.EMPTY) {
			if (Player == EPlayerColor.RED_1) {
				fields[x][y] = EFieldState.BLUE;
			} else if (Player == EPlayerColor.BLUE_2) {
				fields[x][y] = EFieldState.RED;
			}
			x = x-1;
		}
	}
	
	public void test() {
		
		int size = fields.length;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				fields[i][j] = EFieldState.EMPTY;
				fields[size/2-1][size/2-1] = EFieldState.BLUE;
				fields[size/2][size/2] = EFieldState.BLUE;
				fields[size/2-1][size/2] = EFieldState.RED;
				fields[size/2][size/2-1] = EFieldState.RED;
			}
		}
	}

}
