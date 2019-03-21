package com.tiantian.test;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeopleMapper {
    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    /**
     * PO转DTO
     *
     * @param entity PO
     * @return DTO
     */
    @Mapping(target = "phoneNumber", source = "callNumber")
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.age", source = "age")
    PeopleDTO entityToDTO(PeopleEntity entity);

    /**
     * DTO转PO
     *
     * @param peopleDTO DTO
     * @param entity    PO
     */
    @Mapping(target = "callNumber", source = "phoneNumber")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "age", source = "user.age")
    void updateEntityFromDto(PeopleDTO peopleDTO, @MappingTarget PeopleEntity entity);

    public static void main(String[] args) {

        //PO转DTO
        PeopleEntity peopleEntity = new PeopleEntity(18, "yoyo", "13215849",
                "shanghai ", "fdhf@163.com");
        PeopleDTO peopleDTO = PeopleMapper.INSTANCE.entityToDTO(peopleEntity);

        //DTO转PO
        User user = new User(21, "jack");
        PeopleDTO newP = new PeopleDTO("000000",
                "changsha ", "jack@163.com", user);
        PeopleEntity newEntity = new PeopleEntity();
        PeopleMapper.INSTANCE.updateEntityFromDto(newP, newEntity);


        System.out.println("PO转DTO peopleEntity==>" + peopleEntity.toString() + "\n peopleDTO==>" + peopleDTO.toString());
        System.out.println("DTO转PO PeopleDTO==>" + newP.toString() + "\n peopleDTO==>" + newEntity.toString());
    }
}
