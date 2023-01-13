package com.jean.dsCommerce.services;

import com.jean.dsCommerce.dtos.OrderDto;
import com.jean.dsCommerce.dtos.UserDto;
import com.jean.dsCommerce.entities.Order;
import com.jean.dsCommerce.entities.User;
import com.jean.dsCommerce.repositories.OrderRepository;
import com.jean.dsCommerce.repositories.UserRepository;
import com.jean.dsCommerce.services.exceptions.DatabaseException;
import com.jean.dsCommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> result = userRepository.findAll(pageable);
        return result.map(x -> new UserDto(x));
    }

    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found!"));
        return new UserDto(user);
    }

    @Transactional
    public UserDto insert(UserDto dto) {
        User entity = new User();


        for (OrderDto p : dto.getOrders()) {
            Order endereco = orderRepository.getReferenceById(p.getId());
            entity.getOrders().add(endereco);
        }

        copyDtoToEntity(dto, entity);
        entity = userRepository.save(entity);
        return new UserDto(entity);
    }

    @Transactional
    public UserDto update(Long id, UserDto dto) {
        try {
            User entity = userRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = userRepository.save(entity);
            return new UserDto(entity);
        } catch (
                EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(UserDto dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setBirthDate(dto.getBirthDate());
        entity.setRoles(dto.getRoles());
    }
}
