/**********************************************************
  Copyright (C) 2001 	Daniel Selman

  First distributed with the book "Java 3D Programming"
  by Daniel Selman and published by Manning Publications.
  http://manning.com/selman

  This program is free software; you can redistribute it and/or
  modify it under the terms of the GNU General Public License
  as published by the Free Software Foundation, version 2.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  The license can be found on the WWW at:
  http://www.fsf.org/copyleft/gpl.html

  Or by writing to:
  Free Software Foundation, Inc.,
  59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.

  Authors can be contacted at:
  Daniel Selman: daniel@selman.org

  If you make changes you think others would like, please 
  contact one of the authors or someone at the 
  www.j3d.org web site.
**************************************************************/

package org.selman.java3d.book.avatartest;

import javax.vecmath.*;
import javax.media.j3d.*;
import java.net.*;
import java.awt.*;

import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.*;
import org.selman.java3d.book.common.*;

/**
* This class is a simple behavior that invokes the KeyNavigator
* to modify the view platform transform.
*/
public class Building extends ComplexObject
{	
	private final float				BUILDING_WIDTH = 1.0f;
	private final float				BUILDING_LENGTH = 1.0f;

	public Building( Component comp, Group g, int nFlags )
	{
		super( comp, g, nFlags );
	}

	private float getRandomNumber( float basis, float random )
	{
		return basis + ( (float) Math.random( ) * random * 2 ) - (random);
	}

	protected Group createGeometryGroup( Appearance app, Vector3d position, Vector3d scale, String szTextureFile, String szSoundFile )
	{
		int nPrimFlags = 0;

		if( (m_nFlags & ComplexObject.TEXTURE) == ComplexObject.TEXTURE )
		{
			nPrimFlags |= Primitive.GENERATE_TEXTURE_COORDS;
			setTexture( app, szTextureFile );
		}

		return new Box( getRandomNumber( BUILDING_WIDTH, 0.25f ), (float) position.y, getRandomNumber( BUILDING_LENGTH, 0.15f ), nPrimFlags, app );		
	}
}
