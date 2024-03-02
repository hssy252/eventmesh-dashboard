/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.dashboard.console.mapper.meta;

import org.apache.eventmesh.dashboard.console.entity.meta.MetaEntity;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Mybatis Mapper for the table of meta.
 */
@Mapper
public interface MetaMapper {
    @Select("SELECT * FROM meta WHERE id = #{id}")
    MetaEntity selectById(MetaEntity metaEntity);

    @Select("SELECT * FROM meta WHERE cluster_id = #{clusterId}")
    MetaEntity selectByClusterId(MetaEntity metaEntity);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO meta (name, type, version, cluster_id, host, port, role, username, params, status)"
        + " VALUES ( #{name}, #{type}, #{version}, #{clusterId}, #{host}, #{port}, #{role}, #{username}, #{params}, #{status})")
    void insert(MetaEntity metaEntity);

    @Update("UPDATE meta SET status = #{status} WHERE id = #{id}")
    void update(MetaEntity metaEntity);

    @Delete("DELETE FROM meta WHERE id = #{id}")
    void deleteById(MetaEntity metaEntity);
}
