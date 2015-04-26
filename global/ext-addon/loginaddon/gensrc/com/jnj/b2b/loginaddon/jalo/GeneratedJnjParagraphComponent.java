/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Apr 26, 2015 2:49:18 PM                     ---
 * ----------------------------------------------------------------
 */
package com.jnj.b2b.loginaddon.jalo;

import com.jnj.b2b.loginaddon.constants.LoginaddonConstants;
import de.hybris.platform.cms2.jalo.contents.components.CMSParagraphComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cms2.jalo.contents.components.CMSParagraphComponent JnjParagraphComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedJnjParagraphComponent extends CMSParagraphComponent
{
	/** Qualifier of the <code>JnjParagraphComponent.componentVersion</code> attribute **/
	public static final String COMPONENTVERSION = "componentVersion";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CMSParagraphComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(COMPONENTVERSION, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjParagraphComponent.componentVersion</code> attribute.
	 * @return the componentVersion
	 */
	public Long getComponentVersion(final SessionContext ctx)
	{
		return (Long)getProperty( ctx, COMPONENTVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjParagraphComponent.componentVersion</code> attribute.
	 * @return the componentVersion
	 */
	public Long getComponentVersion()
	{
		return getComponentVersion( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjParagraphComponent.componentVersion</code> attribute. 
	 * @return the componentVersion
	 */
	public long getComponentVersionAsPrimitive(final SessionContext ctx)
	{
		Long value = getComponentVersion( ctx );
		return value != null ? value.longValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjParagraphComponent.componentVersion</code> attribute. 
	 * @return the componentVersion
	 */
	public long getComponentVersionAsPrimitive()
	{
		return getComponentVersionAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjParagraphComponent.componentVersion</code> attribute. 
	 * @param value the componentVersion
	 */
	public void setComponentVersion(final SessionContext ctx, final Long value)
	{
		setProperty(ctx, COMPONENTVERSION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjParagraphComponent.componentVersion</code> attribute. 
	 * @param value the componentVersion
	 */
	public void setComponentVersion(final Long value)
	{
		setComponentVersion( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjParagraphComponent.componentVersion</code> attribute. 
	 * @param value the componentVersion
	 */
	public void setComponentVersion(final SessionContext ctx, final long value)
	{
		setComponentVersion( ctx,Long.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjParagraphComponent.componentVersion</code> attribute. 
	 * @param value the componentVersion
	 */
	public void setComponentVersion(final long value)
	{
		setComponentVersion( getSession().getSessionContext(), value );
	}
	
}
