package bogdan.imagefilters.effect;

/**
 * Factory of cool effects
 * 
 * @author bogdan
 * 
 */
public class EffectLibrary {

	public static Effect Anna() {
		Effect effect = new EffectBuilder()
		.contrast(-10)
		.adjust(0.0f, 0.5f, 0.0f)
		.getEffect();

		return effect;
	}

	public static Effect Anna2() {

		Effect effect = new EffectBuilder()
		.expose(-10)
		.adjust(0.0f, 0.5f, 0.0f)
		.getEffect();

		return effect;
	}

	public static Effect Sepia() {
		Effect effect = new EffectBuilder()
		.contrast(40)
		.saturate(-40)
		.sepia()
		.adjust(0.4f, 0.0f, 0.0f)
		.getEffect();

		return effect;
	}
	
	public static Effect BlueGreen(){
		int shadows = Integer.parseInt("002066", 16);
		int midtones= Integer.parseInt("3A6A82", 16);
		int highlights = Integer.parseInt("FFFFFF", 16);
		
		Effect effect = new EffectBuilder()
		.tritone(shadows,midtones,highlights)
		.getEffect();
		
		return effect;		
	}

	public static Effect Pop1() {
		int shadows = Integer.parseInt("ff00cc", 16);
		int midtones = Integer.parseInt("ffff33", 16);
		int highlights = Integer.parseInt("ffff00", 16);

		Effect effect = new EffectBuilder()
		.tritone(shadows, midtones, highlights)
		.getEffect();

		return effect;

	}

	public static Effect Pop2() {
		int shadows = Integer.parseInt("0000ff", 16);
		int midtones = Integer.parseInt("ff0033", 16);
		int highlights = Integer.parseInt("ff6600", 16);

		Effect effect = new EffectBuilder()
		.tritone(shadows, midtones, highlights)
		.getEffect();

		return effect;

	}

	public static Effect RedScale() {
		int shadows = Integer.parseInt("000000", 16);
		int midtones = Integer.parseInt("ea190a", 16);
		int highlights = Integer.parseInt("ffff00", 16);

		Effect effect = new EffectBuilder()
		.contrast(30)
		.tritone(shadows, midtones, highlights)
		.getEffect();

		return effect;

	}

	public static Effect Invert() {
		Effect effect = new EffectBuilder()
		.invert()
		.getEffect();

		return effect;
	}

	public static Effect Sofia() {
		Effect effect = new EffectBuilder()
		.contrast(40)
		.adjust(0.0f, 0.5f, 0.0f)
		.getEffect();

		return effect;
	}

	public static Effect ColdDecember() {
		int shadows = Integer.parseInt("002066", 16);
		int midtones = Integer.parseInt("3A6A82", 16);
		int highlights = Integer.parseInt("FFFFFF", 16);

		Effect effect = new EffectBuilder()
		.tritone(shadows, midtones, highlights)
		.getEffect();

		return effect;
	}

	public static Effect RedBW() {
		Effect effect = new EffectBuilder()
		.contrast(20)
		.redbw()
		.contrast(50)
		.getEffect();

		return effect;
	}

	public static Effect BlueBW() {
		Effect effect = new EffectBuilder()
		.contrast(20)
		.bluebw()
		.contrast(50)
		.getEffect();

		return effect;
	}

	public static Effect Apollo() {
		Effect effect = new EffectBuilder()
		.apollo()
		.getEffect();

		return effect;

	}

	public static Effect EarlyBird() {
		Effect effect = new EffectBuilder()
		.earlyBird()
		.getEffect();

		return effect;
	}

	public static Effect Gotham() {
		Effect effect = new EffectBuilder()
		.gotham()
		.getEffect();

		return effect;
	}

	public static Effect Hashville() {
		Effect effect = new EffectBuilder()
		.hashVille()
		.getEffect();

		return effect;
	}

	public static Effect Hefe() {
		Effect effect = new EffectBuilder()
		.hefe()
		.getEffect();

		return effect;
	}

	public static Effect LordKelvin() {
		Effect effect = new EffectBuilder()
		.lordKevin()
		.getEffect();

		return effect;
	}

	public static Effect Lomo() {
		Effect effect = new EffectBuilder()
		.lomo()
		.getEffect();

		return effect;
	}

	public static Effect Walden() {
		Effect effect = new EffectBuilder()
		.walden()
		.getEffect();

		return effect;
	}

	public static Effect Xpro() {
		Effect effect = new EffectBuilder()
		.xpro()
		.getEffect();

		return effect;
	}

	public static Effect Toaster() {
		Effect effect = new EffectBuilder()
		.toaster()
		.getEffect();

		return effect;
	}

	public static Effect NinthenSeventeSeven() {
		Effect effect = new EffectBuilder()
		.ninthenSeventeSeven()
		.getEffect();

		return effect;
	}
}
