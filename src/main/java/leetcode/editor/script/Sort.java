package leetcode.editor.script;

/**
 * @ClassName Sort
 * @Description //TODO
 * @Author fangjiaxin
 * @Date 2021/12/14
 */
public class Sort {
    // 冒泡排序，a表示数组，n表示数组大小
//    原地 稳定 o(n2)
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        // 最坏要进行n次循环
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    // 插入排序，a表示数组，n表示数组大小
//    原地、稳定 o(n2)
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    // 选择排序，排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
//    原地，不稳定，始终o(n2)
    public void selectSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            int tmp = i;
            int min = a[i];
            for (int j = i; j < n; j++) {
                if (min > a[j]) {
                    tmp = j;
                    min = a[j];
                }
            }
            if (tmp != i) {
                int s = a[i];
                a[i] = a[tmp];
                a[tmp] = s;
            }
        }
    }

    // 归并排序
//    不是原地，稳定，始终o(nlog(n))，需要额外o(n)的空间

    // 快速排序
    public void quick_sort(int[] a, int n) {
        quick_sort_c(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    // 原地、不稳定
    // 为了防止栈溢出，可以规定深度上限，后续用插入排序等完成
    // p起点，r终点
    public void quick_sort_c(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quick_sort_c(a, p, q - 1);
        quick_sort_c(a, q + 1, r);
    }

    // partition选择得不好，就得o(n2)
    public int partition(int[] a, int p, int r) {
        // 选择数组末尾元素作为pivot
        int pivot = a[r];
        int i = p;
        // a[0,i]<pivot 
        for (int j = p; j < r - 1; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // 利用快速排序，O(n)时间复杂度内求无序数组中的第K大元素
    public void findMaxK(int[] a, int k) {

    }

    // 桶排序：适合用在外部排序中。所谓的外部排序就是数据存储在外部磁盘中，数据量比较大，内存有限，无法将数据全部加载到内存中。
    // 先分桶，再桶内快速排序

    // 计数排序：特殊的桶排序，数据的范围<数据的个数
    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        // 从后往前遍历，保证稳定性
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }

    // 基数排序，如手机号排序问题，可以用k次桶排序的算法完成，必须是稳定排序
    // 基数排序要求数据可以划分成高低位，位之间有递进关系。比较两个数，我们只需要比较高位，高位相同的再比较低位。而且每一位的数据范围不能太大


    // 堆排序
    // 时间复杂度是$O(nlog n)$ 不是稳定

    public static void main(String[] args) {
        Sort s = new Sort();
        int[] a = new int[]{11, 8, 9, 3, 7, 2, 5};
        s.selectSort(a, 7);
        System.out.println(a);
    }

}
