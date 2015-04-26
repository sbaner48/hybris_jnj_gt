/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Apr 26, 2015 2:49:18 PM                     ---
 * ----------------------------------------------------------------
 */
package com.jnj.b2b.loginaddon.jalo;

import com.jnj.b2b.loginaddon.constants.LoginaddonConstants;
import de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent JnjLinkComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedJnjLinkComponent extends CMSLinkComponent
{
	/** Qualifier of the <code>JnjLinkComponent.details</code> attribute **/
	public static final String DETAILS = "details";
	/** Qualifier of the <code>JnjLinkComponent.shiftRight</code> attribute **/
	public static final String SHIFTRIGHT = "shiftRight";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CMSLinkComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(DETAILS, AttributeMode.INITIAL);
		tmp.put(SHIFTRIGHT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjLinkComponent.details</code> attribute.
	 * @return the details
	 */
	public Media getDetails(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedJnjLinkComponent.getDetails requires a session language", 0 );
		}
		return (Media)getLocalizedProperty( ctx, DETAILS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjLinkComponent.details</code> attribute.
	 * @return the details
	 */
	public Media getDetails()
	{
		return getDetails( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjLinkComponent.details</code> attribute. 
	 * @return the localized details
	 */
	public Map<Language,Media> getAllDetails(final SessionContext ctx)
	{
		return (Map<Language,Media>)getAllLocalizedProperties(ctx,DETAILS,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjLinkComponent.details</code> attribute. 
	 * @return the localized details
	 */
	public Map<Language,Media> getAllDetails()
	{
		return getAllDetails( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjLinkComponent.details</code> attribute. 
	 * @param value the details
	 */
	public void setDetails(final SessionContext ctx, final Media value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedJnjLinkComponent.setDetails requires a session language", 0 );
		}
		setLocalizedProperty(ctx, DETAILS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjLinkComponent.details</code> attribute. 
	 * @param value the details
	 */
	public void setDetails(final Media value)
	{
		setDetails( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjLinkComponent.details</code> attribute. 
	 * @param value the details
	 */
	public void setAllDetails(final SessionContext ctx, final Map<Language,Media> value)
	{
		setAllLocalizedProperties(ctx,DETAILS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjLinkComponent.details</code> attribute. 
	 * @param value the details
	 */
	public void setAllDetails(final Map<Language,Media> value)
	{
		setAllDetails( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjLinkComponent.shiftRight</code> attribute.
	 * @return the shiftRight
	 */
	public Boolean isShiftRight(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, SHIFTRIGHT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjLinkComponent.shiftRight</code> attribute.
	 * @return the shiftRight
	 */
	public Boolean isShiftRight()
	{
		return isShiftRight( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjLinkComponent.shiftRight</code> attribute. 
	 * @return the shiftRight
	 */
	public boolean isShiftRightAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isShiftRight( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjLinkComponent.shiftRight</code> attribute. 
	 * @return the shiftRight
	 */
	public boolean isShiftRightAsPrimitive()
	{
		return isShiftRightAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjLinkComponent.shiftRight</code> attribute. 
	 * @param value the shiftRight
	 */
	public void setShiftRight(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, SHIFTRIGHT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjLinkComponent.shiftRight</code> attribute. 
	 * @param value the shiftRight
	 */
	public void setShiftRight(final Boolean value)
	{
		setShiftRight( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjLinkComponent.shiftRight</code> attribute. 
	 * @param value the shiftRight
	 */
	public void setShiftRight(final SessionContext ctx, final boolean value)
	{
		setShiftRight( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjLinkComponent.shiftRight</code> attribute. 
	 * @param value the shiftRight
	 */
	public void setShiftRight(final boolean value)
	{
		setShiftRight( getSession().getSessionContext(), value );
	}
	
}
