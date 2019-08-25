package sort;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	    冒泡排序
//		快速排序
//		简单选择排序
//		直接插入排序
//		int temp = 0;
		int[] a = new int[] { 1, 3, 5, 4, 6, 8, 2, 1, 4, 10 };

//      for (int i=0; i<a.length - 1 ; i++) { /* 外循环为排序趟数，len个数进行len-1趟 */
//          for (int j=0; j<a.length-1-i; j++) { /* 内循环为每趟比较的次数，第i趟比较len-i次 */
//              if (a[j] > a[j+1]) { /* 相邻元素比较，若逆序则交换（升序为左大于右，降序反之） */
//                  temp = a[j];
//                  a[j] = a[j+1];
//                  a[j+1] = temp;
//              }
//          }
//          System.out.println("第" + i + "趟：" + Arrays.toString(a));
//      }
//      System.out.println("冒泡排序后：" + Arrays.toString(a));

		directSort(a);

	}

	/************************ 快速排序运用的递归思想 **********************************/
//  选择一个基数，一般我们选择第一个数，
//  然后把大于该数的放右边小于该数的放左边，
//  然后分别对左右两边用同样的方法处理，直到排序结束。   
//	quickSort(a, 0, a.length - 1);
//	System.out.println(Arrays.toString(a));
//	ChoseSort(a);
	private static void ChoseSort(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= a.length - 1; i++) {
			// tempt 也是类似于一个基数值
			int tempt = a[i];
			int position = i;
			for (int j = i; j < a.length - 1; j++) {
				if (a[j] < tempt) {
					// 记录tempt的值
					tempt = a[j];
//				     更改当前的position；
					position = j;
				}
			}
			// 寻找下个位置
			a[position] = a[i];
			a[i] = tempt;
		}
		System.out.println(Arrays.toString(a));
	}

	/************************ 选择排序运用的递归思想 **********************************/
//       简单选择排序思想就是先循环遍历整个数组，找到最小的值与第一个位置数交换
//       ，然后找的第二个较小的值得与第二个位置的数交换，以此类推

	private static void quickSort(int[] a, int low, int height) {
		// TODO Auto-generated method stub
		// 进行角标的判断
		if (low < height) {
			// 取出基准的值
			int midValue = gitMidValue(a, low, height);
			// 从左向右递归
			quickSort(a, low, midValue - 1);
			// 从右向左递归
			quickSort(a, midValue + 1, height);
		}
	}

	private static int gitMidValue(int[] a, int low, int height) {
		// TODO Auto-generated method stub
		// 首先取出一个值作为基准值
		int temp = a[low];
		while (low < height) {
			// 进行看是否有比基准值大的数
			while (low < height && a[height] >= temp) {
				height--;
			}
			// 如果跳出循环说明a[height]<基准值 需要向右移动
			a[low] = a[height];
			System.out.println(Arrays.toString(a));
			// 相同如果a[low]>=tempt则需要向左移动
			while (low < height && a[low] <= temp) {
				low++;
			}
			// 如果跳出循环说明a[low]<基准值 需要向右移动
			a[height] = a[low];
		}
		a[low] = temp; // 基数归位
		System.out.println(Arrays.toString(a));
		return low; // 返回基数的位置
	}

	// ***********************directSort 直接插入排序思想*******************************
//	直接插入排序很好理解，就是从一组元素中取一个元素（肯定是有序的，就一个嘛，称有序元素组）
//	，然后在剩下的元素中每次取一个元素使劲地往有序的元素组插，插到你满意为止。

	private static void directSort(int[] a) {
		// TODO Auto-generated method stub
//	    遍历数组 ，默认第一个数是有序列的，所以要从第二个数进行比较

		for (int i = 1; i < a.length ; i++) {
//			取出一个临时的值用作比较
			int tempt = a[i];
			int j = i-1;
//			由数组左后一个开始
			for (;j>=0&&a[j]>tempt; j--) {
				  
					  a[j+1]=a[j];
			}
			  a[j+1]=tempt;

		}
	    System.out.println("直接插入排序后：" + Arrays.toString(a));

	}

}
