/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.gov.demoiselle.portal.evento.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EventoConfiguracao service. Represents a row in the &quot;demoiselle_EventoConfiguracao&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.gov.demoiselle.portal.evento.model.impl.EventoConfiguracaoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.gov.demoiselle.portal.evento.model.impl.EventoConfiguracaoImpl}.
 * </p>
 *
 * @author Clovis Lemes Ferreira Junior
 * @see EventoConfiguracao
 * @see br.gov.demoiselle.portal.evento.model.impl.EventoConfiguracaoImpl
 * @see br.gov.demoiselle.portal.evento.model.impl.EventoConfiguracaoModelImpl
 * @generated
 */
public interface EventoConfiguracaoModel extends BaseModel<EventoConfiguracao> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a evento configuracao model instance should use the {@link EventoConfiguracao} interface instead.
	 */

	/**
	 * Returns the primary key of this evento configuracao.
	 *
	 * @return the primary key of this evento configuracao
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this evento configuracao.
	 *
	 * @param primaryKey the primary key of this evento configuracao
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the evento configuracao ID of this evento configuracao.
	 *
	 * @return the evento configuracao ID of this evento configuracao
	 */
	public long getEventoConfiguracaoId();

	/**
	 * Sets the evento configuracao ID of this evento configuracao.
	 *
	 * @param eventoConfiguracaoId the evento configuracao ID of this evento configuracao
	 */
	public void setEventoConfiguracaoId(long eventoConfiguracaoId);

	/**
	 * Returns the company ID of this evento configuracao.
	 *
	 * @return the company ID of this evento configuracao
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this evento configuracao.
	 *
	 * @param companyId the company ID of this evento configuracao
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this evento configuracao.
	 *
	 * @return the user ID of this evento configuracao
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this evento configuracao.
	 *
	 * @param userId the user ID of this evento configuracao
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this evento configuracao.
	 *
	 * @return the user uuid of this evento configuracao
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this evento configuracao.
	 *
	 * @param userUuid the user uuid of this evento configuracao
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this evento configuracao.
	 *
	 * @return the create date of this evento configuracao
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this evento configuracao.
	 *
	 * @param createDate the create date of this evento configuracao
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this evento configuracao.
	 *
	 * @return the modified date of this evento configuracao
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this evento configuracao.
	 *
	 * @param modifiedDate the modified date of this evento configuracao
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the evento ID of this evento configuracao.
	 *
	 * @return the evento ID of this evento configuracao
	 */
	public long getEventoId();

	/**
	 * Sets the evento ID of this evento configuracao.
	 *
	 * @param eventoId the evento ID of this evento configuracao
	 */
	public void setEventoId(long eventoId);

	/**
	 * Returns the aberto ao publico of this evento configuracao.
	 *
	 * @return the aberto ao publico of this evento configuracao
	 */
	public boolean getAbertoAoPublico();

	/**
	 * Returns <code>true</code> if this evento configuracao is aberto ao publico.
	 *
	 * @return <code>true</code> if this evento configuracao is aberto ao publico; <code>false</code> otherwise
	 */
	public boolean isAbertoAoPublico();

	/**
	 * Sets whether this evento configuracao is aberto ao publico.
	 *
	 * @param abertoAoPublico the aberto ao publico of this evento configuracao
	 */
	public void setAbertoAoPublico(boolean abertoAoPublico);

	/**
	 * Returns the cidade do evento of this evento configuracao.
	 *
	 * @return the cidade do evento of this evento configuracao
	 */
	@AutoEscape
	public String getCidadeDoEvento();

	/**
	 * Sets the cidade do evento of this evento configuracao.
	 *
	 * @param cidadeDoEvento the cidade do evento of this evento configuracao
	 */
	public void setCidadeDoEvento(String cidadeDoEvento);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(EventoConfiguracao eventoConfiguracao);

	public int hashCode();

	public CacheModel<EventoConfiguracao> toCacheModel();

	public EventoConfiguracao toEscapedModel();

	public String toString();

	public String toXmlString();
}