package RotateMatrix;

public class rotateMatrix {

	public static void rotate(int matrix[][]){
		int n = matrix.length;
		for(int layer = 0; layer < n/2; layer++){
			int first = layer;
			int last = n-1-first;
			int right = 0;
			int offset = 0;
			for(int i = first; i < last; i++){
				offset = i - first;
				//save the right
				right = matrix[i][last];
				//put the top to the right
				matrix[i][last] = matrix[first][i];
				//put the left to the top
				matrix[first][i] = matrix[last - offset][first];
				//put the bottom to the left
				matrix[last - offset][first] = matrix[last][last - offset];
				//put the left to the bottom
				matrix[last][last - offset] = right;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{1,2,3,4},
						  {5,6,7,8},
						  {9,10,11,12},
						  {13,14,15,16}};
		System.out.println("row =" + matrix.length + "column" + matrix[0].length);
		rotate(matrix);
		System.out.println("After rotation:");
		for(int i = 0; i < 4;i++){
			for(int j = 0; j < 4; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}

