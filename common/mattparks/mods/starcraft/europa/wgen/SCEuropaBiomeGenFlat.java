package mattparks.mods.starcraft.europa.wgen;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCEuropaBiomeGenFlat extends SCEuropaBiomeGenBase
{
    public SCEuropaBiomeGenFlat(int par1)
    {
        super(par1);
        this.setBiomeName("europaFlat");
        this.setColor(11111111);
        this.minHeight = 1.5F;
        this.maxHeight = 0.4F;
    }
}
