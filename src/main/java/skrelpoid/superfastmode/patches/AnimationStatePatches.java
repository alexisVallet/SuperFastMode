package skrelpoid.superfastmode.patches;

import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;

import skrelpoid.superfastmode.SuperFastMode;

// Keeps animations at normal speed
public class AnimationStatePatches {
	@SpirePatch(cls = "com.esotericsoftware.spine.AnimationState", method = "update")
	public static class Update {
		public static void Prefix(Object o, @ByRef(type = "float") float[] delta) {
			if (delta[0] == SuperFastMode.getMultDelta()) {
				delta[0] = SuperFastMode.getDelta();
			}
		}
	}
}