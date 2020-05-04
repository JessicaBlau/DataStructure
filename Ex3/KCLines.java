package semester2;
import java.util.ArrayList;

public class KCLines {

	public class Point {
		double x,y;
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	int k = 0;
	ArrayList<Point> lines = new ArrayList<>();

	public void init(int k) {
		this.k = k;
	}
	public void Add(double x, double y) {
		if (lines.isEmpty()) {
			lines.add(new Point(x,y));
		}
		else {
			int min = 0;
			int max = lines.size()-1;
			while(min <= max) {
				int mid = (min + max)/2;
				if(min == max) {
					if(lines.get(max).x > x) {
						lines.add(max,new Point(x,y));
					}
					if(lines.get(max).x < x) {
						if(lines.size()-1 != max) {
							lines.add(++max, new Point(x,y));
						}

						else {
							lines.add(new Point(x,y));
						}
					}
					break;
				}
				if(lines.get(mid).x < x) {
					min = ++mid;
				}
				if(lines.get(mid).x > x) {
					max = mid;
				}
			}

		}
	}
	public void Delete(double x, double y) {
		int min = 0;
		int max = lines.size()-1;
		while(min <= max) {
			int mid = (min + max)/2;
			if (lines.get(mid).x == x) {
				lines.remove(mid);
				break;
			}
			if(lines.get(mid).x < x) {
				min = ++mid;
			}
			if(lines.get(mid).x > x) {
				max = mid;
			}
		}

	}
	public boolean KCenter(double x, double y) {
		return (k < lines.size() && x >= lines.get(k).x && x < lines.get(lines.size()-k).x) ;
	}
}
