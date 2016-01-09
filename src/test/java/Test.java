import org.gt4j.annas.util.EqualityChecker;

public class Test implements EqualityChecker<String> {

	@Override
	public boolean check(Object a, Object b) {
		return a.getClass().equals(b.getClass());
	}

}
