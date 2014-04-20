package mattparks.mods.starcraft.mercury.wgen;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCMercuryBiomeGenFlat extends SCMercuryBiomeGenBase
{
    public SCMercuryBiomeGenFlat(int par1)
    {
        super(par1);
        this.setBiomeName("mercuryFlat");
        this.setColor(11111111);
        this.minHeight = 1.5F;
        this.maxHeight = 0.4F;
    }
}
