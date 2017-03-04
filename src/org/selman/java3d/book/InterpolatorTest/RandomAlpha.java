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

package org.selman.java3d.book.interpolatortest;

import java.util.*;
import java.io.*;
import java.net.*;

import javax.media.j3d.*;
import javax.vecmath.*;

// this class defines an Alpha class that returns a random
// value every N milliseconds.
public class RandomAlpha extends Alpha
{
	protected long					m_LastQueryTime = 0;
	protected float					m_Alpha = 0;
	protected final int				m_kUpdateInterval = 10000;

	public RandomAlpha( )
	{
	}

	// core method override
	// returns the Alpha value for a given time
	public float value( long time )
	{
		if( System.currentTimeMillis( ) - m_LastQueryTime > m_kUpdateInterval )
		{
			m_LastQueryTime = System.currentTimeMillis( );
			m_Alpha = (float) Math.random( );			
		}

		return m_Alpha;
	}
}
