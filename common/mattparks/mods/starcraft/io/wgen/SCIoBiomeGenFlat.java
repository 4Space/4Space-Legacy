package mattparks.mods.starcraft.io.wgen;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCIoBiomeGenFlat extends SCIoBiomeGenBase
{
    public SCIoBiomeGenFlat(int par1)
    {
        super(par1);
        this.setBiomeName("ioFlat");
        this.setColor(11111111);
        this.minHeight = 1.5F;
        this.maxHeight = 0.4F;
    }
}
