package bogdan.imagefilters.effect;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.filter.*;
import bogdan.imagefilters.effect.filter.instagram.*;
import bogdan.imagefilters.effect.layer.*;
import bogdan.imagefilters.effect.layer.Layer.*;


public class EffectBuilder {
	
	private Effect effect;
	
	public EffectBuilder(){
		this.effect = new Effect();
	}
	
	public Effect getEffect(){
		return effect;
	}
	
	public EffectBuilder adjust(float pr, float pg, float pb) {

		Filter adjust = new Adjust(pr, pg, pb);
		this.effect.addFilter(adjust);

		return this;
	}

	public EffectBuilder alpha(int p) {

		Filter alpha = new Alpha(p);
		this.effect.addFilter(alpha);

		return this;
	}

	public EffectBuilder blur(int typeBlur) {

		Filter blur = new Blur(typeBlur);
		this.effect.addFilter(blur);

		return this;
	}

	public EffectBuilder brighten(int p) {

		Filter brighten = new Brighten(p);
		this.effect.addFilter(brighten);

		return this;
	}

	public EffectBuilder contrast(int p) {

		Filter contrast = new Contrast(p);
		this.effect.addFilter(contrast);

		return this;
	}

	public EffectBuilder expose(int p) {

		Filter expose = new Expose(p);
		this.effect.addFilter(expose);

		return this;
	}

	public EffectBuilder fill(int r, int g, int b) {

		Filter fill = new Fill(r, g, b);
		this.effect.addFilter(fill);

		return this;
	}

	public EffectBuilder gamma(int p) {

		Filter gamma = new Gamma(p);
		this.effect.addFilter(gamma);

		return this;
	}

	public EffectBuilder invert() {

		Filter invert = new Invert();
		this.effect.addFilter(invert);

		return this;
	}

	public EffectBuilder posterize(int p) {

		Filter posterize = new Posterize(p);
		this.effect.addFilter(posterize);

		return this;
	}

	public EffectBuilder saturate(int p) {

		Filter saturate = new Saturate(p);
		this.effect.addFilter(saturate);

		return this;
	}

	public EffectBuilder sepia() {

		Filter sepia = new Sepia();
		this.effect.addFilter(sepia);

		return this;
	}

	public EffectBuilder sharpen() {

		Filter sharpen = new Sharpen();
		this.effect.addFilter(sharpen);

		return this;
	}

	public EffectBuilder substract(int r, int g, int b) {

		Filter substract = new Substract(r, g, b);
		this.effect.addFilter(substract);

		return this;
	}

	public EffectBuilder grey() {

		Filter bw = new BlackWhite();
		this.effect.addFilter(bw);

		return this;
	}

	public EffectBuilder tritone(int shadows, int midtones, int highlights) {

		Filter tritone = new Tritone(shadows, midtones, highlights);
		this.effect.addFilter(tritone);

		return this;
	}

	public EffectBuilder redbw() {

		Filter redbw = new RedBW();
		this.effect.addFilter(redbw);

		return this;
	}

	public EffectBuilder bluebw() {

		Filter bluebw = new BlueBW();
		this.effect.addFilter(bluebw);

		return this;
	}

	public EffectBuilder layerAddition(Bitmap filterImage, LayerMergeMode mode) {

		Filter addition = new Addition(filterImage, mode);
		this.effect.addFilter(addition);

		return this;
	}

	public EffectBuilder layerDifference(Bitmap filterImage, LayerMergeMode mode) {

		Filter addition = new Difference(filterImage, mode);
		this.effect.addFilter(addition);

		return this;
	}

	public EffectBuilder layerExclusion(Bitmap filterImage, LayerMergeMode mode) {

		Filter addition = new Exclusion(filterImage, mode);
		this.effect.addFilter(addition);

		return this;
	}

	public EffectBuilder layerMultiply(Bitmap filterImage, LayerMergeMode mode) {

		Filter addition = new Multiply(filterImage, mode);
		this.effect.addFilter(addition);

		return this;
	}

	public EffectBuilder layerOverlay(Bitmap filterImage, LayerMergeMode mode) {

		Filter addition = new Overlay(filterImage, mode);
		this.effect.addFilter(addition);

		return this;
	}

	public EffectBuilder layerScreen(Bitmap filterImage, LayerMergeMode mode) {

		Filter addition = new Screen(filterImage, mode);
		this.effect.addFilter(addition);

		return this;
	}

	public EffectBuilder layerSoftLight(Bitmap filterImage, LayerMergeMode mode) {

		Filter addition = new SoftLight(filterImage, mode);
		this.effect.addFilter(addition);

		return this;
	}

	public EffectBuilder apollo() {

		Filter apollo = new Apollo();
		this.effect.addFilter(apollo);

		return this;
	}

	public EffectBuilder earlyBird() {

		Filter earlyBird = new EarlyBird();
		this.effect.addFilter(earlyBird);

		return this;
	}

	public EffectBuilder gotham() {

		Filter gotham = new Gotham();
		this.effect.addFilter(gotham);

		return this;
	}

	public EffectBuilder hashVille() {

		Filter hasville = new Hashville();
		this.effect.addFilter(hasville);

		return this;
	}

	public EffectBuilder hefe() {

		Filter hefe = new Hefe();
		this.effect.addFilter(hefe);

		return this;
	}

	public EffectBuilder lomo() {

		Filter lomo = new Lomo();
		this.effect.addFilter(lomo);

		return this;
	}

	public EffectBuilder lordKevin() {

		Filter lordKevin = new LordKelvin();
		this.effect.addFilter(lordKevin);

		return this;
	}

	public EffectBuilder ninthenSeventeSeven() {

		Filter ninthenSeventeSeven = new NinthenSeventeSeven();
		this.effect.addFilter(ninthenSeventeSeven);

		return this;
	}

	public EffectBuilder toaster() {

		Filter toaster = new Toaster();
		this.effect.addFilter(toaster);

		return this;
	}

	public EffectBuilder walden() {

		Filter walden = new Walden();
		this.effect.addFilter(walden);

		return this;
	}

	public EffectBuilder xpro() {

		Filter xpro = new Xpro();
		this.effect.addFilter(xpro);

		return this;
	}
}
